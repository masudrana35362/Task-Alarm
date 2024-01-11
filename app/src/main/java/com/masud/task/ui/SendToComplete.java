package com.masud.task.ui;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.masud.task.R;
import com.masud.task.receiver.AlertReceiver;


public class SendToComplete extends AppCompatActivity {
  Button CompleteTask;
    String title,des,time;
    int id;
    Intent intent;
    public static final String TITLE=" com.masud.task.TITLE";
    public static final String DESC=" com.masud.task.DESC";
    public static final String TIME=" com.masud.task.TIME";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_send_to_complete);
        TextView setDesc = findViewById (R.id.setDescription);
        TextView setDate = findViewById (R.id.setTime);
        TextView setTitle = findViewById (R.id.setTitle);
        CompleteTask=findViewById (R.id.CompleteTask);

        setTitle ("Task Alarm");

        intent=getIntent ();
        title=intent.getStringExtra (AlertReceiver.taskNotificationHelper.TITLE);
        des=intent.getStringExtra (AlertReceiver.taskNotificationHelper.DESC);
        time=intent.getStringExtra (AlertReceiver.taskNotificationHelper.TIME);

        setTitle.setText (title);
        setDesc.setText (des);
        setDate.setText (time);


        CompleteTask.setOnClickListener (v -> {
            SendToComplete.this.showCompleteTaskDialog ();

        });

    }

    private void showCompleteTaskDialog() {
        AlertDialog.Builder builder=new AlertDialog.Builder (this);
        builder.setTitle ("Complete Task?");
        builder.setMessage ("do you wish to complete this task?");
        builder.setCancelable (false);

        builder.setPositiveButton ("Yes", (dialog, which) -> SendToComplete.this.sendToComplete ());
        builder.setNegativeButton ("No", (dialog, which) -> {
            //stop ongoing alarm tone
            AlertReceiver.taskRingtone.stop ();
            //cancel vibration
            AlertReceiver.vibrator.cancel ();
            dialog.dismiss ();
            finish ();
            Toast.makeText (getApplicationContext (),"Cancelled",Toast.LENGTH_SHORT).show ();

        });
        builder.create ().show ();
    }
    //this method sends data to mainActivity, then CompletedTaskfragment takes it from there
    private void sendToComplete() {
        //stop ongoing alarm tone
        AlertReceiver.taskRingtone.stop ();

        //cancel vibration
        AlertReceiver.vibrator.cancel ();

        Intent data = new Intent (this, MainActivity.class);
        data.putExtra (TITLE, title);
       data.putExtra (TIME, time);
        startActivity (data);
        finish ();
        Toast.makeText (this,"Task Completed",Toast.LENGTH_SHORT).show ();
    }

}
