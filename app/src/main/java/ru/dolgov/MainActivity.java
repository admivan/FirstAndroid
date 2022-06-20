package ru.dolgov;

import static android.graphics.Color.parseColor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button rename;
    private TextView name;
    private EditText editName;
    private Switch swichFon;
    private CheckBox checkOnOff;
    private ToggleButton toggleButton;
    private Button nextWork;
    private Button backWork;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        onInitializationView();// Вызов метода для инициализации элементов
    }

    /**
     * Метод используется для инициализации всех элементов в первом лояулте
     */
    public void onInitializationView() {
        rename = findViewById(R.id.rename);
        rename.setOnClickListener(this);
        name = findViewById(R.id.name);
        editName = findViewById(R.id.edit_name);
        swichFon = findViewById(R.id.switch_fon);
        swichFon.setOnClickListener(this);
        checkOnOff = findViewById(R.id.check_box);
        checkOnOff.setOnClickListener(this);
        toggleButton = findViewById(R.id.toggle);
        toggleButton.setOnClickListener(this);
        nextWork = findViewById(R.id.next_work);
        nextWork.setOnClickListener(this);
    }

    /**
     * Метод используется для инициализации всех элементов во втором лояулте
     */
    private void onInitalizationViewTwo() {
        backWork = findViewById(R.id.back_work);
        backWork.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.rename:
                name.setText(editName.getText());//Смена текста из edittext
                break;
            case R.id.switch_fon:
                if (swichFon.isChecked()) {
                    name.setBackgroundColor(parseColor("#4285B4"));// Смена фона
                } else {
                    name.setBackgroundColor(parseColor("#FFFFFF"));
                }
                break;
            case R.id.check_box:
                if (checkOnOff.isChecked()) {
                    name.setText("Я чек бокс я включен");// Вывод сообщения в зависимости от состояния
                } else {
                    name.setText("Я чек бокс я выключен");
                }
                break;
            case R.id.toggle:
                if (toggleButton.isChecked()) {
                    name.setText("Я toogle включен");// Вывод сообщения в зависимости от состояния
                } else {
                    name.setText("Я toogle выключен");
                }
                break;
            case R.id.next_work:
                setContentView(R.layout.two_layout); //переход в другой layout
                onInitalizationViewTwo();
                break;
            case R.id.back_work:
                setContentView(R.layout.activity_main); //переход в первый layout
                onInitializationView();
                break;
        }

    }
}