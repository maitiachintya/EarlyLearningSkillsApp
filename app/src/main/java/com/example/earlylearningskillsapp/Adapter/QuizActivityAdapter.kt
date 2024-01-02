package com.example.earlylearningskillsapp.Adapter
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.earlylearningskillsapp.Activity.QuizActivity
import com.example.earlylearningskillsapp.Activity.ScoreActivity
import com.example.earlylearningskillsapp.Modelclass.QuizImageModel
import com.example.earlylearningskillsapp.R

class QuizActivityAdapter(
    val context : QuizActivity,
    var quizitemlists : ArrayList<QuizImageModel>,
    var score : Int,
    val recyclerView : RecyclerView
)
    : RecyclerView.Adapter<QuizActivityAdapter.QuizViewHolder>(){

    class QuizViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val letterimg : ImageView = itemView.findViewById(R.id.textvw_img)
        val itemimg1 : ImageView = itemView.findViewById(R.id.identityimg)
        val itemimg2 : ImageView = itemView.findViewById(R.id.identityimg1)
        val itemimg3 : ImageView = itemView.findViewById(R.id.identityimg2)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuizViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.quizimageview, parent, false)
        return QuizViewHolder(view)
    }
    @Override

    override fun onBindViewHolder(holder: QuizViewHolder, position: Int) {
        val quizImageModel : QuizImageModel = quizitemlists[position]
        holder.letterimg.setImageResource(quizImageModel.alphabetimg)
        holder.itemimg1.setImageResource(quizImageModel.img1)
        holder.itemimg2.setImageResource(quizImageModel.img2)
        holder.itemimg3.setImageResource(quizImageModel.img3)
        holder.itemimg1.setOnClickListener(View.OnClickListener {
            if(quizImageModel.correctpos == 1){
                score = score + 1
            }
            if(quizitemlists.size - 1 == position){
                //Toast.makeText(context,"Your Score Is "+score.toString(),Toast.LENGTH_LONG).show()
                val scoreActivityIntent = Intent(context, ScoreActivity :: class.java)
                val bundle = Bundle()
                bundle.putInt("score", score)
                scoreActivityIntent.putExtras(bundle)
                context.startActivity(scoreActivityIntent)
                context.finish()
            }
            recyclerView.scrollToPosition(position + 1)
        })
        holder.itemimg2.setOnClickListener(View.OnClickListener {
            if(quizImageModel.correctpos == 2){
                score = score + 1
            }
            if(quizitemlists.size - 1 == position){
              //  Toast.makeText(context,"Your Score Is "+score.toString(),Toast.LENGTH_LONG).show()
                val scoreActivityIntent = Intent(context, ScoreActivity :: class.java)
                val bundle = Bundle()
                bundle.putInt("score", score)
                scoreActivityIntent.putExtras(bundle)
                context.startActivity(scoreActivityIntent)
                context.finish()
            }
            recyclerView.scrollToPosition(position + 1)
        })
        holder.itemimg3.setOnClickListener(View.OnClickListener {
            if(quizImageModel.correctpos == 3){
                score = score + 1
            }
            if(quizitemlists.size - 1 == position){
                //Toast.makeText(context,"Your Score Is "+score.toString(),Toast.LENGTH_LONG).show()
               /* val scoreIntent= Intent(context, ScoreActivity :: class.java)
                scoreIntent.putExtra("score",score)
                context.startActivity(scoreIntent)*/
                val scoreActivityIntent = Intent(context, ScoreActivity :: class.java)
                val bundle = Bundle()
                bundle.putInt("score", score)
                scoreActivityIntent.putExtras(bundle)
                context.startActivity(scoreActivityIntent)
                context.finish()
            }
            recyclerView.scrollToPosition(position + 1)
        })
    }
    override fun getItemCount() : Int {
        return quizitemlists.size
    }
}