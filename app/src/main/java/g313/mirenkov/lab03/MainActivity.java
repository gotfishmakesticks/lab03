package g313.mirenkov.lab03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText amount;
    TextView result;
    Spinner top_spin, bot_spin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        amount = findViewById(R.id.amount);
        result = findViewById(R.id.result);
        top_spin = findViewById(R.id.top_spin);
        bot_spin = findViewById(R.id.bot_spin);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);

        adapter.add("mm");
        adapter.add("cm");
        adapter.add("m");
        adapter.add("km");

        top_spin.setAdapter(adapter);
        bot_spin.setAdapter(adapter);
    }

    public void on_calculate(View v)
    {
        String get = amount.getText().toString();
        double amnt = 0.0;
        try
        {
            amnt = Double.parseDouble(get);
        }
        catch(Exception e)
        {
            Toast.makeText(this, "Ошибка: введено пустое значение", Toast.LENGTH_LONG).show();
        }
        int top_index = top_spin.getSelectedItemPosition();
        int bot_index = bot_spin.getSelectedItemPosition();
        int[] pows = {0, 1, 3, 6};
        double res = amnt * Math.pow(10, pows[top_index]) / Math.pow(10, pows[bot_index]);
        result.setText(String.valueOf(res));
    }
}