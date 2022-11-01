package com.example.assign1

import androidx.appcompat.app.AppCompatActivity
import android.annotation.SuppressLint
import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.google.android.material.snackbar.Snackbar
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button1: Button = findViewById(R.id.btCreateWorkout)
        val options1=arrayOf("Choose a Workout", "Cardio", "Body Building", "Strength Building", "Cross Fit")
        val spinnerVal: Spinner = findViewById(R.id.spWorkoutType)
        spinnerVal.adapter= ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,options1)
        var flag= "Choose a Workout"
        val wt: EditText = findViewById(R.id.edWeight)
        val ht: EditText = findViewById(R.id.edHeight)


        spinnerVal.onItemSelectedListener= object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                flag= options1.get(p2)
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }

        val resultTv: TextView = findViewById(R.id.textWorkout)
        button1.setOnClickListener { view ->
            if (flag=="Choose a Workout"){
                Snackbar.make(view,"Invalid Entry", Snackbar.LENGTH_SHORT).show()
            }
            else{
                var w: Double = wt.text.toString().toDouble()
                var h: Double = ht.text.toString().toDouble()
                val intensity: Int= ((w+h)% 10).toInt()
                if (flag=="Cardio"){
                    resultTv.text=("-" + (intensity*10) +"mins Normal Paced Walking\n" +
                            "-"+ (intensity*5)+"mins Fast Paced Walking\n"+
                            "-"+ (intensity*3)+"mins Going Up Stairs\n"+
                            "-"+ (intensity*3)+"mins Jogging In Place")
                }
                else if (flag=="Body Building"){
                    resultTv.text=("-" + (intensity*4) +" reps Mid Pr Dumbbell Curls\n" +
                            "-"+ (intensity*5)+" reps Low Pr Barbell Deadlifts\n"+
                            "-"+ (intensity*2)+" reps Mid Pr Curved Dumbbell Curls\n"+
                            "-"+ (intensity*3)+" reps Mid Pr Leg Press")
                }
                else if (flag=="Strength Building"){
                    resultTv.text=("-" + (intensity*2) +" reps Max Pr Dumbbell Curls\n" +
                            "-"+ (intensity*2)+" reps Max Pr Barbell Deadlifts\n"+
                            "-"+ (intensity*3)+" reps Mid Pr Curved Dumbbell Curls\n"+
                            "-"+ (intensity*3)+" reps Mid Pr Leg Press")
                }
                else if (flag=="Cross Fit"){
                    resultTv.text=("-" + (intensity*10) +"mins Normal Paced Walking\n" +
                            "-"+ (intensity*5)+"mins Fast Paced Walking\n"+
                            "-" + (intensity*3) +" reps Mid Pr Dumbbell Curls\n"+
                            "-"+ (intensity*5)+"mins Jogging In Place")
                }
            }
        }
    }







}