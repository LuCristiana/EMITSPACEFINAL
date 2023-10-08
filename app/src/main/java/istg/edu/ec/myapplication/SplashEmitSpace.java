package istg.edu.ec.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.widget.VideoView;

public class SplashEmitSpace extends AppCompatActivity {
    VideoView videoView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_emit_space);
   /* new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(SplashEmitSpace.this,MainActivity.class);
                startActivity(intent);
                finish();

            }
        }, 1500);*/

        videoView = (VideoView) findViewById(R.id.videoView);

        Uri video = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.emit);
        videoView.setVideoURI(video);

        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer mp) {
                startNextActivity();
            }
        });

        videoView.start();
    }

    private void startNextActivity() {
        if (isFinishing())
            return;
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }



}
