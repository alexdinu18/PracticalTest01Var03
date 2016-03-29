package ro.pub.cs.systems.eim.practicaltest01var03;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class PracticalTest01Var03MainActivity extends Activity {
	
	  private EditText riddle = null;
	  private EditText answer = null;
	  private Button playButton = null;
	  
	  private ButtonClickListener buttonClickListener = new ButtonClickListener();
	  private class ButtonClickListener implements View.OnClickListener {
		    @Override
		    public void onClick(View view) {
			    	if (riddle.getText().toString().trim().length() > 0  && answer.getText().toString().trim().length() > 0) {
			    	riddle.setText(riddle.getText().toString());
			    	answer.setText(answer.getText().toString());
			    	
	    	        Intent intent = new Intent(getApplicationContext(), PracticalTest01Var02PlayActivity.class);
	    	        intent.putExtra("answer", answer.getText().toString());
	    	        intent.putExtra("riddle", riddle.getText().toString());
	    	        startActivityForResult(intent, 1);
			  }
		    }
	  }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var03_main);
        
        riddle = (EditText)findViewById(R.id.riddle);
        answer = (EditText)findViewById(R.id.answer);
     
        playButton = (Button)findViewById(R.id.button);
        playButton.setOnClickListener(buttonClickListener);
    }


    protected void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putString("riddle", riddle.getText().toString());
        savedInstanceState.putString("answer", answer.getText().toString());
      }
     
      @Override
      protected void onRestoreInstanceState(Bundle savedInstanceState) {
        if (savedInstanceState.containsKey("riddle")) {
          riddle.setText(savedInstanceState.getString("riddle"));
        } else {
          riddle.setText("");
        }
        if (savedInstanceState.containsKey("answer")) {
          answer.setText(savedInstanceState.getString("answer"));
        } else {
          answer.setText("");
        }
      }
      
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.practical_test01_var03_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
