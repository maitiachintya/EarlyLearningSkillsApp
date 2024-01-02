/*
package com.example.earlylearningskillsapp.customview

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import androidx.annotation.Nullable
import kotlin.math.roundToInt

class DrawingView(context: Context?) : View(context) {
    lateinit var drawpath : Path
    lateinit var canvaspaint : Paint
    lateinit var drawpaint : Paint
    //var a : String ="hghjg"
    //static int paintColor = 0xFFFF0000;
    var paintColor : Int = 0xFFFF0000.toInt()
    // private  float STROKE_WIDTH = 5f;
    var STROKE_WIDTH : Float = 5f
    lateinit var drawCanvas: Canvas
    lateinit var canvasBitmap: Bitmap
    var erase : Boolean = false
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        setupDrawing()
        setErase(erase)
    }

    private fun setupDrawing() {
        drawpath = Path()
        drawpaint = Paint()
        drawpaint.setColor(paintColor)
        drawpaint.setAntiAlias(true)
        drawpaint.setStrokeWidth(STROKE_WIDTH);
        drawpaint.setStyle(Paint.Style.STROKE);
        drawpaint.setStrokeJoin(Paint.Join.ROUND);
        drawpaint.setStrokeCap(Paint.Cap.ROUND);
        canvaspaint = Paint(Paint.DITHER_FLAG)
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        canvasBitmap = Bitmap.createBitmap(w,h,Bitmap.Config.ARGB_8888)
        drawCanvas = Canvas(canvasBitmap)
    }

    private fun setErase(erase: Boolean) {
        var erase = erase
        drawpaint = Paint()
        if(erase){
            setupDrawing()
            var srcColor : Int = 0x00000000
            val mode = PorterDuff.Mode.CLEAR
            val porterDuffColorFilter = PorterDuffColorFilter(srcColor, mode)
            drawpaint.setColorFilter(porterDuffColorFilter);
            drawpaint.setColor(srcColor);
            drawpaint.xfermode = PorterDuffXfermode(mode)
        }
        else{
            setupDrawing()
        }
    }

    override fun onDrawForeground(canvas: Canvas?) {
        canvas?.drawBitmap(canvasBitmap, 0f, 0f, canvaspaint)
        canvas?.drawPath(drawpath, drawpaint);
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        canvaspaint.setColor(paintColor)
        val touchX: Float? = event?.x
        val touchY: Float? = event?.y
        when (event?.action) {
            MotionEvent.ACTION_DOWN -> {
                drawpath.moveTo(touchX!!, touchY!!)
            }
            MotionEvent.ACTION_MOVE -> {
                drawCanvas.drawPath(drawpath, drawpaint)
                drawpath.lineTo(touchX!!, touchY!!)
            }
            MotionEvent.ACTION_UP -> {
               drawpath.lineTo(touchX!!, touchY!!)
                drawCanvas.drawPath(drawpath, drawpaint)
                drawpath.reset()
            }
            else -> return false
        }
        invalidate()
        return true
    }

    fun getPaintAlpha(): Int {
        return (STROKE_WIDTH.toFloat() / 255 * 100).roundToInt()
    }

    fun setPaintAlpha(newAlpha: Int) {
        STROKE_WIDTH = (newAlpha.toFloat() / 100 * 255).roundToInt().toFloat()
        drawpaint.strokeWidth = newAlpha.toFloat()
    }
}
*/
