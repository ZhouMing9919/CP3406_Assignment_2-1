//InstructionsActivity created to display the structure and rules of the game
package example.assignmentone.cp3406.cp3406_assignment_2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class InstructionsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instructions);
    }

    public void buttonPressed(View view){
        Intent goToMenu = new Intent(this, MainActivity.class);
        startActivity(goToMenu);
    }
}
