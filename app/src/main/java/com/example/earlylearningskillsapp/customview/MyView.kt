/*
package com.example.earlylearningskillsapp.customview

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import androidx.annotation.Nullable


class MyView(context: Context?, @Nullable attrs: AttributeSet?) :
    View(context, attrs) {
    private var drawPath: Path? = null
    private var drawPaint: Paint? = null
    private  var canvasPaint:android.graphics.Paint? = null
    private var STROKE_WIDTH = 5f
    private val path: Path = Path()
    var paintColor = -0x10000
    private val drawCanvas: Canvas? = null
    private var erase = false
    private val canvasBitmap: Bitmap? = null
     val paint: Paint = Paint()

    //Constructor
    init {
        isFocusable = true
        isFocusableInTouchMode = true
        PaintSettings()
        drawPath = Path()
    }

    fun DrawingView(context: Context?, attrs: AttributeSet?) {
        super(context, attrs)
        setupDrawing()
        setErase(erase)
    }

    // Get x and y and follow user motion events


    private fun PaintSettings() {
        paint.setStyle(Paint.Style.STROKE)
        //paint.setColor(Color.RED)
        paint.setStrokeWidth(16F)
    }

    fun getPaintAlpha(): Int {
        return Math.round(STROKE_WIDTH / 255 * 100)
    }

    fun setPaintAlpha(newAlpha: Int) {
        STROKE_WIDTH = Math.round(newAlpha.toFloat() / 100 * 255).toFloat()
        drawPaint?.setStrokeWidth(newAlpha.toFloat())
    }
    fun setErase(isErase: Boolean) {
        erase = isErase
        drawPaint = Paint()
        if (erase) {
            setupDrawing()
            val srcColor = 0x00000000
            val mode = PorterDuff.Mode.CLEAR
            val porterDuffColorFilter = PorterDuffColorFilter(srcColor, mode)
            drawPaint!!.setColorFilter(porterDuffColorFilter)
            drawPaint!!.setColor(srcColor)
            drawPaint!!.setXfermode(PorterDuffXfermode(mode))
        } else {
            setupDrawing()
        }
    }
    override fun onDraw(canvas: Canvas) {
        canvas.drawBitmap(canvasBitmap!!, 0f, 0f, canvasPaint)
        canvas.drawPath(
            drawPath!!,
            drawPaint!!
        )
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
       // canvasPaint!!.color = com.example.earlylearningskillsapp.customview.MyView.paintColor
        val touchX = event.x
        val touchY = event.y
        when (event.action) {
            MotionEvent.ACTION_DOWN -> MyView.moveTo(
                touchX,
                touchY
            )
            MotionEvent.ACTION_MOVE -> {
                drawCanvas!!.drawPath(
                    com.example.earlylearningskillsapp.customview.MyView.,
                    drawPaint!!
                )
                com.example.earlylearningskillsapp.customview.MyVi.lineTo(
                    touchX,
                    touchY
                )
            }
            MotionEvent.ACTION_UP -> {
                com.example.earlylearningskillsapp.customview.MyView.drawPath.lineTo(
                    touchX,
                    touchY
                )
                drawCanvas!!.drawPath(
                    com.example.earlylearningskillsapp.customview.MyView.drawPath,
                    drawPaint!!
                )
                com.example.earlylearningskillsapp.customview.MyView.drawPath.reset()
            }
            else -> return false
        }
        //redraw
        invalidate()
        return true
    }


    private fun setupDrawing() {
        drawPath = Path()
        //com.example.earlylearningskillsapp.customview.MyView. = Path()
        drawPaint = Paint()
       // drawPaint!!.color = col
        drawPaint!!.isAntiAlias = true
        drawPaint!!.strokeWidth = STROKE_WIDTH
        drawPaint!!.style = Paint.Style.STROKE
        drawPaint!!.strokeJoin = Paint.Join.ROUND
        drawPaint!!.strokeCap = Paint.Cap.ROUND
        canvasPaint = Paint(Paint.DITHER_FLAG)
    }

}*/
