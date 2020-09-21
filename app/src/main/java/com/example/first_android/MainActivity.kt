package com.example.first_android

import android.Manifest
import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.database.Cursor
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.view.View
import androidx.core.content.FileProvider
import androidx.core.net.toFile
import kotlinx.android.synthetic.main.activity_main.*
import java.io.File
import java.io.IOException
import java.net.URI
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    private val OPEN_CAMERA_REQUEST_CODE = 13
    val SELECT_FILE_FROM_STORAGE = 65
    val REQUEST_READ_STORAGE_PERMISSION = 20
    private lateinit var currentPhotoPath: String
    private lateinit var photoFile: File

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        checkStoragePermission()
    }

    fun openCamera(view: View) {
        val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        cameraIntent.resolveActivity(packageManager)
        photoFile = createImageFile()
        val photoURI: Uri? = FileProvider.getUriForFile(this, "com.example.first_android.file_provider", photoFile)
        cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI)
        startActivityForResult(cameraIntent, OPEN_CAMERA_REQUEST_CODE)
    }

    fun browseFile(view: View) {

        val selectFileIntent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI)
        startActivityForResult(selectFileIntent, SELECT_FILE_FROM_STORAGE)

    }

    @SuppressLint("SimpleDateFormat")
    @Throws(IOException::class)
    private fun createImageFile(): File {
// Create an image file name
        val timeStamp: String = SimpleDateFormat("yyyyMMdd_HHmmss").format(Date())
        val storageDir: File = getExternalFilesDir(Environment.DIRECTORY_PICTURES)!!

//            .apply {
//                // Save a file: path for use with ACTION_VIEW intents
//                currentPhotoPath = absolutePath
//            }
        val filenya = File.createTempFile(
            "JPEG_${timeStamp}_", /* prefix */
            ".jpg", /* suffix */
            storageDir /* directory */
        )

        currentPhotoPath = filenya.absolutePath
        println(currentPhotoPath)
        return filenya
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == OPEN_CAMERA_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            val imageBitmap: Bitmap = BitmapFactory.decodeFile(photoFile.absolutePath)
            imageView.setImageBitmap(imageBitmap)
        }

        if(requestCode == SELECT_FILE_FROM_STORAGE && resultCode == Activity.RESULT_OK) {
            println(data?.data.toString())
            println(data?.data?.path)
            val originalPath = getOriginalPathFromUri(data?.data!!)
            val imageFile = File(originalPath)
            val imageBitmap = BitmapFactory.decodeFile(imageFile.absolutePath)
            imageView.setImageBitmap(imageBitmap)
//            val uriFile = data?.data
////            imageView.setImageURI(uriFile)
//            println(data?.data.toString())
//            println(data?.data?.path)
//            val originPath = getOriginalPathFromUri(data?.data!!)
//            println(originPath)
//            photoFile = uriFile?.toFile()!!


//            val imageFile = File(originPath)
        }
    }

    @SuppressLint("Recycle")
    fun getOriginalPathFromUri(contentUri: Uri): String? {
        var originalPath: String? = null
        val projection = arrayOf(MediaStore.Images.Media.DATA)
        val cursor: Cursor? = contentResolver.query(contentUri, projection, null, null, null)
        if (cursor?.moveToFirst()!!) {
            val columnIndex: Int = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA)
            originalPath = cursor.getString(columnIndex)
        }
        return originalPath
    }

    private fun checkStoragePermission(){
        if (checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){
            requestPermissions(arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.WRITE_EXTERNAL_STORAGE),
                REQUEST_READ_STORAGE_PERMISSION)
        }
    }
}


