package com.passwordnotes;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import com.passwordnotes.config.Settings;

/**
 * 基本步骤
 * <p>初始化资源</p>
 * <p>设置初始状态</p>
 * <p>响应变化</p>
 */
public class SettingActivity extends AppCompatActivity {

    private SwitchCompat hidden_item_list_name;
    private SwitchCompat hidden_item_list_password;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        initData();
        initLayout();
        basicOnClickHandler();

    }

    /**
     * 监听点击事件
     */
    private void basicOnClickHandler() {
        // 给开关按钮设置监听状态改变事件
        hidden_item_list_password.setOnCheckedChangeListener(
                (buttonView, isChecked) -> {
                    Settings.showItemListPassword = isChecked;
                    Settings.notifySettingsChanged();
                    setResult(RESULT_OK, intent);
                }
        );
        hidden_item_list_name.setOnCheckedChangeListener((buttonView, isChecked) -> {
            Settings.showItemListName = isChecked;
            Settings.notifySettingsChanged();
            setResult(RESULT_OK, intent);
        });
    }

    /**
     * 引导页面布局
     */
    private void initLayout() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
            actionBar.setCustomView(R.layout.custom_bar_setting);
            actionBar.getCustomView().findViewById(R.id.setting_baseline_back)
                    .setOnClickListener(v -> onBackPressed());

        }

        hidden_item_list_password.setChecked(Settings.showItemListPassword);
        hidden_item_list_name.setChecked(Settings.showItemListName);

    }

    /**
     * 初始化设置数据项
     */
    private void initData() {
        intent = new Intent();
        hidden_item_list_password = findViewById(R.id.setting_hidden_item_list_password);
        hidden_item_list_name = findViewById(R.id.setting_hidden_item_list_name);

    }
}