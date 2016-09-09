package me.mafei.settingitemview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class SettingItemView extends RelativeLayout {

  private static final int ITEM_NORMAL = 0;
  private static final int ITEM_CACHE = 1;
  private static final int ITEM_SWITCH = 2;

  private TextView mTvTitle;
  private ImageView mIvRight;
  private TextView mTvRight;
  private CustomColorSwitchCompat mSwitchCompat;
  private boolean mSwitchState;

  public SettingItemView(Context context) {
    this(context, null);
  }

  public SettingItemView(Context context, AttributeSet attrs) {
    this(context, attrs, 0);
  }

  public SettingItemView(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    init(context, attrs);
  }

  private void init(Context context, AttributeSet attrs) {
    View view = View.inflate(context, R.layout.item_setting_view, this);
    mTvTitle = (TextView) view.findViewById(R.id.setting_base_item_title);
    mTvRight = (TextView) view.findViewById(R.id.setting_base_item_memory);
    mIvRight = (ImageView) view.findViewById(R.id.setting_base_item_iv);
    mSwitchCompat = (CustomColorSwitchCompat) view.findViewById(R.id.setting_base_item_switch);

    TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.SettingItemView);
    String title = typedArray.getString(R.styleable.SettingItemView_item_title);
    String right = typedArray.getString(R.styleable.SettingItemView_item_text_right);
    boolean flag = typedArray.getBoolean(R.styleable.SettingItemView_item_show_right, false);
    int type = typedArray.getInt(R.styleable.SettingItemView_item_type, 0);
    typedArray.recycle();
    setClickable(true);
    mTvTitle.setText(title);
    mTvRight.setText(right);
    mTvRight.setVisibility(flag ? VISIBLE : GONE);
    setBackgroundColor(Color.WHITE);
    setBackgroundResource(R.drawable.selector_setting_item);
    switch (type) {
      case ITEM_NORMAL:
        mIvRight.setBackgroundResource(R.drawable.common_icon_into);
        break;
      case ITEM_CACHE:

        break;
      case ITEM_SWITCH:
        mSwitchCompat.setVisibility(VISIBLE);
        mTvRight.setVisibility(GONE);
        setBackgroundColor(getResources().getColor(R.color.white));
        break;
    }
  }

  public boolean getSwitchState() {
    return mSwitchState;
  }

  public void setmSwitchState(boolean flag) {
    mSwitchCompat.setChecked(flag);
    mSwitchState = flag;
  }

  public void setRightText(String text) {
    mTvRight.setVisibility(VISIBLE);
    mTvRight.setText(text);
  }

  public String getText() {
    return mTvTitle.getText().toString().trim();
  }
}
