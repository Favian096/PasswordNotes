package com.passwordnotes.utils.toaster;

import android.view.View;
import android.widget.TextView;

import com.passwordnotes.utils.toaster.config.IToast;

/**
 *    desc   : 自定义 Toast 基类
 */
public abstract class CustomToast implements IToast {

    /** Toast 布局 */
    private View mView;
    /** Toast 消息 View */
    private TextView mMessageView;
    /** Toast 显示重心 */
    private int mGravity;
    /** Toast 显示时长 */
    private int mDuration;
    /** 水平偏移 */
    private int mXOffset;
    /** 垂直偏移 */
    private int mYOffset;
    /** 水平间距 */
    private float mHorizontalMargin;
    /** 垂直间距 */
    private float mVerticalMargin;
    /** Toast 动画 */
    private final int mAnimations = android.R.style.Animation_Toast;
    /** 短吐司显示的时长，参考至 NotificationManagerService.SHORT_DELAY */
    private final int mShortDuration = 2000;
    /** 长吐司显示的时长，参考至 NotificationManagerService.LONG_DELAY */
    private final int mLongDuration = 3500;

    @Override
    public void setText(int id) {
        if (mView == null) {
            return;
        }
        setText(mView.getResources().getString(id));
    }

    @Override
    public void setText(CharSequence text) {
        if (mMessageView == null) {
            return;
        }
        mMessageView.setText(text);
    }

    @Override
    public void setView(View view) {
        mView = view;
        if (mView == null) {
            mMessageView = null;
            return;
        }
        mMessageView = findMessageView(view);
    }

    @Override
    public View getView() {
        return mView;
    }

    @Override
    public void setDuration(int duration) {
        mDuration = duration;
    }

    @Override
    public int getDuration() {
        return mDuration;
    }

    @Override
    public void setGravity(int gravity, int xOffset, int yOffset) {
        mGravity = gravity;
        mXOffset = xOffset;
        mYOffset = yOffset;
    }

    @Override
    public int getGravity() {
        return mGravity;
    }

    @Override
    public int getXOffset() {
        return mXOffset;
    }

    @Override
    public int getYOffset() {
        return mYOffset;
    }

    @Override
    public void setMargin(float horizontalMargin, float verticalMargin) {
        mHorizontalMargin = horizontalMargin;
        mVerticalMargin = verticalMargin;
    }

    @Override
    public float getHorizontalMargin() {
        return mHorizontalMargin;
    }

    @Override
    public float getVerticalMargin() {
        return mVerticalMargin;
    }

    public int getAnimationsId() {
        return mAnimations;
    }

    public int getShortDuration() {
        return mShortDuration;
    }

    public int getLongDuration() {
        return mLongDuration;
    }
}