package com.example.appreadstories;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestConnection extends AppCompatActivity {

    private TextView connectionStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_connection);

        connectionStatus = findViewById(R.id.tvConnectionStatus);

        // Thực hiện kiểm tra kết nối khi Activity được tạo
        new TestConnectionTask().execute();
    }

    private class TestConnectionTask extends AsyncTask<Void, Void, Boolean> {

        @Override
        protected Boolean doInBackground(Void... voids) {
            String url = "jdbc:mysql://172.20.10.2:3307/appReadStories";
            String user = "root";
            String password = "test001";

            try {
                // Đăng ký Driver
                Class.forName("com.mysql.cj.jdbc.Driver");
                // Kết nối đến cơ sở dữ liệu
                Connection connection = DriverManager.getConnection(url, user, password);
                if (connection != null) {
                    Log.d("DBConnection", "Connected to database!");
                    return true; // Thành công
                }
            } catch (SQLException e) {
                Log.e("DBConnection", "SQLException: " + e.getMessage());
            } catch (ClassNotFoundException e) {
                Log.e("DBConnection", "ClassNotFoundException: " + e.getMessage());
            }
            return false; // Thất bại
        }

        @Override
        protected void onPostExecute(Boolean result) {
            if (result) {
                connectionStatus.setText("Connection successful!");
            } else {
                connectionStatus.setText("Connection failed!");
            }
        }
    }
}
