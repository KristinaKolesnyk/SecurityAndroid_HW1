package com.example.andriods_hw1;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.WifiManager;
import android.os.BatteryManager;
import android.os.Build;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText userNameInput;
    private TextInputEditText passwordInput;
    private MaterialButton loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userNameInput = findViewById(R.id.main_txt_userName);
        passwordInput = findViewById(R.id.main_txt_password);
        loginButton = findViewById(R.id.main_btu_login);

        loginButton.setOnClickListener(v -> attemptLogin());
    }

    private void attemptLogin() {
        int batteryPercentage = getBatteryPercentage(this);
        if (String.valueOf(batteryPercentage).equals(passwordInput.getText().toString()) && isWifiOn() && isBluetoothOn()) {
            updateUI();
        } else {
            Toast.makeText(this, "Login failed: Conditions not met", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean isWifiOn() {
        WifiManager wifiManager = (WifiManager) getSystemService(Context.WIFI_SERVICE);
        return wifiManager.isWifiEnabled();
    }

    private boolean isBluetoothOn() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        return bluetoothAdapter != null && bluetoothAdapter.isEnabled();
    }

    public static int getBatteryPercentage(Context context) {
        if (Build.VERSION.SDK_INT >= 21) {
            BatteryManager batteryManager = (BatteryManager) context.getSystemService(BATTERY_SERVICE);
            return batteryManager.getIntProperty(BatteryManager.BATTERY_PROPERTY_CAPACITY);
        } else {
            IntentFilter intentFilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
            Intent batteryStatus = context.registerReceiver(null, intentFilter);
            int level = batteryStatus != null ? batteryStatus.getIntExtra(BatteryManager.EXTRA_LEVEL, -1) : -1;
            int scale = batteryStatus != null ? batteryStatus.getIntExtra(BatteryManager.EXTRA_SCALE, -1) : -1;
            double batteryPct = level / (double) scale;
            return (int) (batteryPct * 100);
        }
    }

    private void updateUI() {
        startActivity(new Intent(MainActivity.this, NextActivity.class));
    }
}
