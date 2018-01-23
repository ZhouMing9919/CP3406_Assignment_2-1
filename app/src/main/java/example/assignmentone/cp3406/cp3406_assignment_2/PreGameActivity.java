package example.assignmentone.cp3406.cp3406_assignment_2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class PreGameActivity extends AppCompatActivity {
    private SharedPreferences gameSettings;
    private TextView timeInput;
    private TextView qNumInput;
    private TextView topicInput;
    private TextView allowedSkip;
    private int skippedQuestionCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pre_game);
        timeInput = findViewById(R.id.timeInput);
        qNumInput = findViewById(R.id.qNumInput);
        topicInput = findViewById(R.id.topicInput);
        gameSettings = getSharedPreferences("GameSettings", MODE_PRIVATE);
    }

    @Override
    protected void onStart() {
        super.onStart();
        timeInput.setText(Long.toString(gameSettings.getLong("timeLimit", 21000)));
        qNumInput.setText(Integer.toString(gameSettings.getInt("numberOfQuestions", 10)));
        topicInput.setText(gameSettings.getString("gameSubject", null));

        if(gameSettings.getInt("numberOfQuestions", 10) == 10){
            skippedQuestionCount = 2;
        }
        else if(gameSettings.getInt("numberOfQuestions", 10) == 15){
            skippedQuestionCount = 3;
        }
        else{
            skippedQuestionCount = 4;
        }

        gameSettings.edit().putInt("skippedQuestionCount", skippedQuestionCount).apply(); //Storing number of skipped questions allowed
        gameSettings.edit().putInt("QuestionCount", 1).apply(); //Resetting Stored preferences
        gameSettings.edit().putLong("timeScore", 0).apply();
        gameSettings.edit().putInt("gameSkippedQuestionCount", 0).apply();

    }

    public void buttonPressed(View view){
        Intent goToPlay = new Intent(this, PlayActivity.class);
        Intent goToMenu = new Intent(this, MainActivity.class);
        Intent goToSettings = new Intent(this, SettingsActivity.class);

        switch (view.getId()){
            case R.id.playButton:
                startActivity(goToPlay);
                break;
            case R.id.menuButton:
                startActivity(goToMenu);
                break;
            case R.id.settingsButton:
                startActivity(goToSettings);
                break;
        }
    }
}
