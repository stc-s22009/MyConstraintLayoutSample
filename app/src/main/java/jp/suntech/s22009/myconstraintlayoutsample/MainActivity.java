package jp.suntech.s22009.myconstraintlayoutsample;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button confirmButton = findViewById(R.id.btConfirm);
        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showConfirmationDialog();
            }
        });

        // 送信ボタンのクリックリスナーを設定
        Button sendButton = findViewById(R.id.btSend);
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendDialog();
            }
        });

        // クリアボタンのクリックリスナーを設定
        Button clearButton = findViewById(R.id.btClear);
        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearFields();
            }
        });
    }

    private void showConfirmationDialog() {
        EditText etName = findViewById(R.id.etName);
        EditText etEmail = findViewById(R.id.etMail);
        EditText etComment = findViewById(R.id.etComment);
        EditText etEmailTitle = findViewById(R.id.etMailTitle);

        String name = etName.getText().toString();
        String email = etEmail.getText().toString();
        String comment = etComment.getText().toString();
        String emailTitle = etEmailTitle.getText().toString();

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("内容確認");
        builder.setMessage("以下の内容をご確認ください。");
        builder.setMessage("名前: " + name + "\nメールアドレス: " + email + "\nタイトル: " + emailTitle + "\n質問内容: " + comment);

        builder.setPositiveButton("戻る", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String toastMessage = getString(R.string.dialog_nu_toast);
                showToast(toastMessage);
            }
        });
        builder.show();
    }

    private void sendDialog() {

        EditText etName = findViewById(R.id.etName);
        EditText etEmail = findViewById(R.id.etMail);
        EditText etComment = findViewById(R.id.etComment);
        EditText etEmailTitle = findViewById(R.id.etMailTitle);

        String name = etName.getText().toString();
        String email = etEmail.getText().toString();
        String comment = etComment.getText().toString();
        String emailTitle = etEmailTitle.getText().toString();

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("送信\n以下の内容でよろしいですか。");
        builder.setMessage("名前: " + name + "\nメールアドレス: " + email + "\nタイトル: " + emailTitle + "\n質問内容: " + comment);
        builder.setPositiveButton("はい", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String toastMessage = getString(R.string.dialog_ok_toast);
                showToast(toastMessage);
            }
        });
        builder.setNegativeButton("キャンセル", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which){
                String toastMessage = getString(R.string.dialog_ng_toast);
                showToast(toastMessage);
            }
        });
        builder.show();
    }
    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    private void clearFields() {
        EditText etName = findViewById(R.id.etName);
        EditText etEmail = findViewById(R.id.etMail);
        EditText etComment = findViewById(R.id.etComment);
        EditText etEmailTitle = findViewById(R.id.etMailTitle);

        // すべてのEditTextのテキストをクリア（空欄に設定）する
        etName.setText("");
        etEmail.setText("");
        etComment.setText("");
        etEmailTitle.setText("");
    }
}