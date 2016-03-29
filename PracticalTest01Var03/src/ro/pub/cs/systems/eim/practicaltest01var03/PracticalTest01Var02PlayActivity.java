package ro.pub.cs.systems.eim.practicaltest01var03;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PracticalTest01Var02PlayActivity extends Activity {

	private EditText riddle_play = null;
	private EditText answer_play = null;
	private Button check = null;
	private Button back = null;
	private PracticalTest01Var02PlayActivity context = this;
	
	private ButtonClickListener buttonClickListener = new ButtonClickListener();
	private class ButtonClickListener implements View.OnClickListener {
	    @Override
	    public void onClick(View view) {
	    	Intent intent = getIntent();
	    	
	    	String text = intent.getStringExtra("answer");
	      switch(view.getId()) {
	        case R.id.check:
	          Button answer = (Button)findViewById(R.id.answer);
	          if(text.equals(answer_play.getText().toString()))
	        	  Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_LONG).show();
	          else
	        	  Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_LONG).show();
	          break;
	        case R.id.back:
	          setResult(RESULT_CANCELED, null);
	          break;
	      }
	      finish();
	    }
	  }
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_practical_test01_var02_play);
		Intent intent = getIntent();
    	
    	String text = intent.getStringExtra("riddle");
    	
		riddle_play = (EditText)findViewById(R.id.riddle_play);
		riddle_play.setText(text);
        answer_play = (EditText)findViewById(R.id.answer_play);
     
        check = (Button)findViewById(R.id.check);
        back = (Button)	findViewById(R.id.back);
        
        check.setOnClickListener(buttonClickListener);
        back.setOnClickListener(buttonClickListener);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.practical_test01_var02_play, menu);
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
