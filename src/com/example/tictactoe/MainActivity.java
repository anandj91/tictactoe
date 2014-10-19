package com.example.tictactoe;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

	boolean checkCROSS[] = new boolean[9];
	boolean checkDOT[] = new boolean[9];

	enum TURN {
		CROSS, DOT
	}

	TURN turn = TURN.CROSS;

	private void setCellImage(Button b) {
		if (b.getText() == "X" || b.getText() == "O")
			return;

		if (turn == TURN.CROSS) {
			turn = TURN.DOT;
			b.setText("X");
			checkCROSS[getIndex(b.getId())] = true;
			if (checkGame(checkCROSS)) {
				Toast.makeText(getApplicationContext(), "CROSS wins the game",
						Toast.LENGTH_LONG).show();
			}
		} else {
			turn = TURN.CROSS;
			b.setText("O");
			checkDOT[getIndex(b.getId())] = true;
			if (checkGame(checkDOT)) {
				Toast.makeText(getApplicationContext(), "DOT wins the game",
						Toast.LENGTH_LONG).show();
			}
		}

	}

	private boolean checkGame(boolean[] check) {

		boolean rows = (check[0] & check[1] & check[2])
				|| (check[3] & check[4] & check[5])
				|| (check[6] & check[7] & check[8]);
		boolean cols = (check[0] & check[3] & check[6])
				|| (check[1] & check[4] & check[7])
				|| (check[2] & check[5] & check[8]);
		boolean diags = (check[0] & check[4] & check[8])
				|| (check[2] & check[4] & check[6]);
		return rows || cols || diags;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Button[] cells = { (Button) findViewById(R.id.cell1),
				(Button) findViewById(R.id.cell2),
				(Button) findViewById(R.id.cell3),
				(Button) findViewById(R.id.cell4),
				(Button) findViewById(R.id.cell5),
				(Button) findViewById(R.id.cell6),
				(Button) findViewById(R.id.cell7),
				(Button) findViewById(R.id.cell8),
				(Button) findViewById(R.id.cell9) };

		for (int i = 0; i < 9; i++) {
			Log.i("TIC-TAC-TOE", i + "");
			cells[i].setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					setCellImage((Button) v);
				}
			});
		}

	}

	private int getIndex(int id) {
		switch (id) {
		case R.id.cell1:
			return 0;
		case R.id.cell2:
			return 1;
		case R.id.cell3:
			return 2;
		case R.id.cell4:
			return 3;
		case R.id.cell5:
			return 4;
		case R.id.cell6:
			return 5;
		case R.id.cell7:
			return 6;
		case R.id.cell8:
			return 7;
		case R.id.cell9:
			return 8;
		default:
			return -1;

		}
	}

}
