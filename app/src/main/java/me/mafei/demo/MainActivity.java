package me.mafei.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import me.mafei.settingitemview.SettingItemView;

public class MainActivity extends AppCompatActivity {

  private SettingItemView settingBaseRlNotify;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    settingBaseRlNotify= (SettingItemView) findViewById(R.id.setting_base_rl_notify);

    settingBaseRlNotify.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        settingBaseRlNotify.setmSwitchState(settingBaseRlNotify.getSwitchState() ? false : true);
      }
    });
  }
}
