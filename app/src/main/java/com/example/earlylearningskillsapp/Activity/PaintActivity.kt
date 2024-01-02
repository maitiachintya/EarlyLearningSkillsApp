package com.example.earlylearningskillsapp.Activity

import android.content.ContentValues
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.view.View
import android.view.WindowManager
import android.widget.ImageView
import android.widget.SeekBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContentProviderCompat.requireContext
import com.example.earlylearningskillsapp.R
//import com.example.earlylearningskillsapp.customview.MyView
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.FileOutputStream
import java.io.OutputStream

class PaintActivity : AppCompatActivity() {
    //  private lateinit var infoLl: MyView
    private lateinit var saveBtn: ImageView
    var mThickness: SeekBar? = null
    var alteredBitmap: Bitmap? = null
    var imghome: ImageView? = null

    // var imgerase:android.widget.ImageView? = null
    var imgdraw: android.widget.ImageView? = null
    var saveimg: android.widget.ImageView? = null
    private val drawPaint = Paint()

    // private var mDrawLayout: MyView? = null
    private lateinit var seekBar: SeekBar

    // private lateinit var myView: MyView
    private lateinit var downloadIcon: ImageView
    private var isDownloading = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_paint)
        //   infoLl = findViewById(R.id.mycustompaintview)
        //imgerase = findViewById(R.id.eraseop)
        saveBtn = findViewById(R.id.downloading)
        /* saveBtn.setOnClickListener(View.OnClickListener {
            val bitmap = getBitmapFromUiView(infoLl)
            saveBitmapImage(bitmap)
        })*/
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        mThickness = findViewById(R.id.thickness)
        /* myView = findViewById(R.id.mycustompaintview)
        downloadIcon = findViewById(R.id.downloading)
        mDrawLayout = findViewById<View>(R.id.mycustompaintview) as MyView
        mDrawLayout!!.visibility = View.VISIBLE
        mDrawLayout!!.isDrawingCacheEnabled = true
        mDrawLayout!!.isEnabled = true*/
        mThickness?.max = 50
        mThickness?.setProgress(10)
        //mDrawLayout?.setPaintAlpha(mThickness?.getProgress()!!)
        //val currLevel: Int = mDrawLayout.getPaintAlpha()
        //  mThickness.setProgress(currLevel)
        //mDrawLayout!!.invalidate()
        //  myView.paint.setColor( resources.getColor(R.color.purple_200))
        val redcolor = findViewById<ImageView>(R.id.redcolor)
        /* redcolor.setOnClickListener(View.OnClickListener {
            myView.paint.setColor( resources.getColor(R.color.red))
        })*/
        val yellowcolor = findViewById<ImageView>(R.id.yellowcolor)
        /* yellowcolor.setOnClickListener(View.OnClickListener {
            myView.paint.setColor(resources.getColor(R.color.yellow))
        })*/
        val refreshbtn = findViewById<ImageView>(R.id.refreshoption)
        /*  refreshbtn.setOnClickListener(View.OnClickListener {
            val myview = findViewById<>()
        })*/
       // mThickness?.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            /* override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                mDrawLayout?.setPaintAlpha(mThickness?.getProgress()!!)
            }
             */

         //   override fun onStartTrackingTouch(p0: SeekBar?) {

            }

           // override fun onStopTrackingTouch(p0: SeekBar?) {
                // myView.paint.strokeWidth = p0?.progress!!.toFloat()
                // myView.paintColor = resources.getColor(R.color.purple_200)
            }
      //  })

       /* val imghome = findViewById<ImageView>(R.id.homeop)
        imghome.setOnClickListener(View.OnClickListener {
            val homeActivityIntent = Intent(this, HomeActivity::class.java)
            startActivity(homeActivityIntent)
        })
        val imgerase = findViewById<ImageView>(R.id.eraseop)
        imgerase.setOnClickListener(View.OnClickListener {
            *//* fun onClick(v: View?) {
                drawPaint.color = Color.TRANSPARENT
                mDrawLayout!!.setErase(true)
            }*//*
        })*/
       /* val shareimg = findViewById<ImageView>(R.id.shareoption1)
        shareimg.setOnClickListener {
            val shareIntent = Intent(android.content.Intent.ACTION_SEND);
            shareIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);
            shareIntent.setType("image/*");
            shareIntent.putExtra(Intent.EXTRA_SUBJECT, "Insert Subject here");
            //val app_url = "https://drive.google.com/file/d/1prFGKJ4jLPZ06TyMZ58Kdh3HXyMhVjmL/view?usp=sharing";
            // shareIntent.putExtra(android.content.Intent.EXTRA_TEXT,app_url);
            // val bitmap = getBitmapFromUiView(myView)
            val bytes = ByteArrayOutputStream()
            //bitmap.compress(Bitmap.CompressFormat.JPEG, 100, bytes)
            //val path = MediaStore.Images.Media.insertImage(this?.contentResolver, bitmap, "tempimage", null)
            //val uri = Uri.parse(path)

            // Step 6: Put Uri as extra to share intent
            //shareIntent.putExtra(Intent.EXTRA_STREAM, uri)
            startActivity(Intent.createChooser(shareIntent, "Share via"))
        }

    }*/

    private fun saveBitmapImage(bitmap: Bitmap) {
        val timestamp = System.currentTimeMillis()
        val values = ContentValues()
        values.put(MediaStore.Images.Media.MIME_TYPE, "image/png")
        values.put(MediaStore.Images.Media.DATE_ADDED, timestamp)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            values.put(MediaStore.Images.Media.DATE_TAKEN, timestamp)
            values.put(
                MediaStore.Images.Media.RELATIVE_PATH,
                "Pictures/" + getString(R.string.app_name)
            )
            values.put(MediaStore.Images.Media.IS_PENDING, true)
            val uri = contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values)
            if (uri != null) {
                try {
                    val outputStream = contentResolver.openOutputStream(uri)
                    if (outputStream != null) {
                        try {
                            bitmap.compress(Bitmap.CompressFormat.PNG, 100, outputStream)
                            outputStream.close()
                        } catch (e: Exception) {
                            // Log.e(TAG, "saveBitmapImage: ", e)
                            //Toast.makeText(this,"saveBitmapImage","Hello",Toast.LENGTH_LONG).show()
                        }
                    }
                    values.put(MediaStore.Images.Media.IS_PENDING, false)
                    contentResolver.update(uri, values, null, null)

                    Toast.makeText(this, "Saved...", Toast.LENGTH_SHORT).show()
                } catch (e: Exception) {
                    // Log.e(TAG, "saveBitmapImage: ", e)
                }
            }

        } else {
            val imageFileFolder = File(
                Environment.getExternalStorageDirectory()
                    .toString() + '/' + getString(R.string.app_name)
            )
            if (!imageFileFolder.exists()) {
                imageFileFolder.mkdirs()
            }
            val mImageName = "$timestamp.png"
            val imageFile = File(imageFileFolder, mImageName)
            try {
                val outputStream: OutputStream = FileOutputStream(imageFile)
                try {
                    bitmap.compress(Bitmap.CompressFormat.PNG, 100, outputStream)
                    outputStream.close()
                } catch (e: Exception) {
                    //Log.e(TAG, "saveBitmapImage: ", e)
                }
                values.put(MediaStore.Images.Media.DATA, imageFile.absolutePath)
                contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values)

                Toast.makeText(this, "Saved...", Toast.LENGTH_SHORT).show()
            } catch (e: Exception) {
                // Log.e(TAG, "saveBitmapImage: ", e)
            }
        }

    }
}

   /* private fun getBitmapFromUiView(myview: MyView?): Bitmap {
        val returnedBitmap = Bitmap.createBitmap(myview!!.width, myview.height, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(returnedBitmap)
        val bgDrawable = myview.background
        if (bgDrawable != null) {
            //has background drawable, then draw it on the canvas
            bgDrawable.draw(canvas)
        } else {
            //does not have background drawable, then draw white background on the canvas
            canvas.drawColor(Color.WHITE)
        }
        myview.draw(canvas)
        return returnedBitmap
    }
}*/