package com.dc.shopapp.weight;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.dc.shopapp.R;


/**
 * @author Zhangzhenguo
 * @create 2020/1/16
 * @Email 18311371235@163.com
 * @Describe
 */
public class HeadView extends FrameLayout {

    private ImageView headLeftReturn;
    private TextView headCenterTitle;
    private ImageView headRightSearch;
    private onHeadItemClickListener listener;

    public HeadView(@NonNull Context context) {
        super(context);
        initView(context);
    }

    public HeadView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public HeadView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    /**
     * 实例化布局
     *
     * @param context
     */
    private void initView(Context context) {
        View conterView=LayoutInflater.from(context).inflate( R.layout.head_layout, this);
        this.headLeftReturn=conterView.findViewById(R.id.headLeftReturn);
        this.headCenterTitle=conterView.findViewById(R.id.headCenterTitle);
        this.headRightSearch=conterView.findViewById(R.id.headRightSearch);

        headLeftReturn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onHeadReturn(v);
                }
            }
        });
        headRightSearch.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onHeadRight(v);
                }
            }
        });
    }

    /**
     * 设置标题栏返回图标
     *
     * @param iconID
     */
    public void setHeadLeftReturnIcon(int iconID) {
        headLeftReturn.setImageResource(iconID);
    }

    /**
     * 设置标题栏名称
     *
     * @param titleName
     */
    public void setHeadCenterTitle(String titleName) {
        headCenterTitle.setText(titleName);
    }

    /**
     * 设置标题栏搜索按钮图标
     *
     * @param iconID
     */
    public void setHeadRightSearch(int iconID) {
        headRightSearch.setImageResource(iconID);
    }


    public interface onHeadItemClickListener {
        void onHeadReturn(View view);
        void onHeadRight(View view);
    }

    public void setOnHeadItemClickListener(onHeadItemClickListener listener) {
        this.listener = listener;
    }
}