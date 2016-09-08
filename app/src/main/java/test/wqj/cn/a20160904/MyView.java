package test.wqj.cn.a20160904;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by MR.WEN on 2016/9/6.
 */

public class MyView extends ViewGroup {

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        // TODO Auto-generated constructor stub
    }

    @Override
//    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//        measureChildren(widthMeasureSpec, heightMeasureSpec);
//        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
//    }

    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int mViewGroupWidth = getMeasuredWidth();  //当前ViewGroup的总宽度
        int mViewGroupHeight= getMeasuredHeight();  //当前ViewGroup的总高度
        int mPainterPosX = l;  //当前绘图光标横坐标位置
        int mPainterPosY = t;  //当前绘图光标纵坐标位置
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childView = getChildAt(i);
            int width = mViewGroupWidth/4;
            int height = mViewGroupHeight/4;
            //如果剩余的空间不够，则移到下一行开始位置
            if (mPainterPosX + width > mViewGroupWidth) {
                mPainterPosX = l;
                mPainterPosY += height;
            }
            //执行ChildView的绘制
            childView.layout(mPainterPosX, mPainterPosY, mPainterPosX + width, mPainterPosY + height);
            //记录当前已经绘制到的横坐标位置
            mPainterPosX += width;
        }
    }
}