package com.tencent.mm.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint.FontMetrics;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.view.s;
import android.text.Layout;
import android.text.Layout.Alignment;
import android.text.Spanned;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.a.a;
import com.tencent.mm.pluginsdk.ui.b;
import com.tencent.mm.pluginsdk.ui.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public class AddressView extends View implements a, d.a {
    private static final String TAG = "MicroMsg.AddressView";
    public final int AVATAR_LAYOUT_WIDTH;
    public final int AVATAR_PADDING;
    public final int AVATAR_START_POS;
    public final int AVATAR_WIDTH;
    public final int COMMON_PADDING;
    public final int DESCRIPTION_PADDING;
    public final float DESCRIPTION_TEXT_SIZE;
    private int NAME_RIGHT_PADDING;
    public final float NAME_TEXT_SIZE;
    public final int TEXT_TOP_PADDING;
    public final int WEIBO_ICON_SIZE;
    Drawable avatarDrawable;
    Context context;
    float density;
    String description;
    private FontMetrics descriptionFontMetrics;
    private TextPaint descriptionPaint;
    CharSequence destNickName;
    private TextPaint displayNamePaint;
    Drawable drawable;
    private FontMetrics fm;
    boolean imageViewHasSetBounds;
    StaticLayout layout;
    boolean nameIsSpanned;
    boolean needInvaildate;
    boolean needInvaliate;
    BitmapDrawable needMask;
    boolean needUpdatePostion;
    CharSequence nickName;
    private int nickNameCurrentTextColor;
    int nickNameHeight;
    private ColorStateList nickNameTextColor;
    int nickNameWidth;
    StaticLayout nickNamelayout;
    int nickWidth;
    float textBaseY;

    public AddressView(Context context) {
        this(context, null, 0);
    }

    public AddressView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AddressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(29078);
        this.drawable = getResources().getDrawable(R.drawable.aoc);
        this.needUpdatePostion = true;
        this.AVATAR_LAYOUT_WIDTH = 0;
        this.AVATAR_WIDTH = 0;
        this.NAME_TEXT_SIZE = (float) com.tencent.mm.bz.a.al(context, R.dimen.m5);
        this.DESCRIPTION_TEXT_SIZE = (float) com.tencent.mm.bz.a.al(context, R.dimen.nk);
        this.WEIBO_ICON_SIZE = getResources().getDimensionPixelSize(R.dimen.na);
        this.AVATAR_START_POS = 0;
        this.AVATAR_PADDING = 0;
        this.COMMON_PADDING = 0;
        this.DESCRIPTION_PADDING = getResources().getDimensionPixelSize(R.dimen.l9) * 2;
        this.TEXT_TOP_PADDING = getResources().getDimensionPixelSize(R.dimen.nj);
        this.NAME_RIGHT_PADDING = getResources().getDimensionPixelSize(R.dimen.dm);
        if (this.displayNamePaint == null) {
            this.displayNamePaint = generateOnePaint();
        }
        AppMethodBeat.o(29078);
    }

    public void setNickNameTextColor(ColorStateList colorStateList) {
        this.nickNameTextColor = colorStateList;
    }

    /* Access modifiers changed, original: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.i(29079);
        super.onDraw(canvas);
        updatePosition();
        if (this.avatarDrawable != null) {
            this.avatarDrawable.draw(canvas);
        }
        if (this.needMask != null) {
            this.needMask.draw(canvas);
        }
        if (this.nameIsSpanned) {
            canvas.save();
            canvas.translate((float) (this.AVATAR_LAYOUT_WIDTH + this.AVATAR_PADDING), (float) ((getHeight() - this.nickNameHeight) / 2));
            this.nickNamelayout.draw(canvas);
            canvas.restore();
            AppMethodBeat.o(29079);
            return;
        }
        if (bo.isNullOrNil(this.description)) {
            if (this.destNickName != null) {
                canvas.drawText(this.destNickName, 0, this.destNickName.length(), (float) (this.AVATAR_LAYOUT_WIDTH + this.AVATAR_PADDING), ((((float) getHeight()) - (this.fm.bottom - this.fm.top)) / 2.0f) - this.fm.top, this.displayNamePaint);
            }
        } else if (this.destNickName != null) {
            Canvas canvas2 = canvas;
            canvas2.drawText(this.destNickName, 0, this.destNickName.length(), (float) (this.AVATAR_LAYOUT_WIDTH + this.AVATAR_PADDING), ((float) this.TEXT_TOP_PADDING) + (((((float) getHeight()) - (this.fm.bottom - this.fm.top)) / 2.0f) - (this.fm.top / 3.0f)), this.displayNamePaint);
            int width = getWidth();
            float measureText = this.descriptionPaint.measureText(this.description);
            String str = this.description;
            if (measureText > ((float) (width - this.DESCRIPTION_PADDING))) {
                int i = 1;
                while (i < this.description.length()) {
                    String substring = this.description.substring(0, i);
                    if (this.descriptionPaint.measureText(substring) >= ((float) (width - this.DESCRIPTION_PADDING))) {
                        str = str + "...";
                        break;
                    } else {
                        i++;
                        str = substring;
                    }
                }
            }
            canvas2 = canvas;
            canvas2.drawText(str, 0, str.length(), (float) (this.AVATAR_LAYOUT_WIDTH + this.AVATAR_PADDING), ((float) this.TEXT_TOP_PADDING) + (((((float) getHeight()) - (this.descriptionFontMetrics.bottom - this.descriptionFontMetrics.top)) / 2.0f) - ((float) ((int) (((double) this.descriptionFontMetrics.top) * 1.7d)))), this.descriptionPaint);
            AppMethodBeat.o(29079);
            return;
        }
        AppMethodBeat.o(29079);
    }

    public void setName(CharSequence charSequence) {
        AppMethodBeat.i(29080);
        if (this.nickName == null || !this.nickName.equals(charSequence)) {
            this.needInvaildate = true;
        }
        this.nickName = charSequence;
        this.nameIsSpanned = charSequence instanceof Spanned;
        getFontMetrics();
        AppMethodBeat.o(29080);
    }

    private FontMetrics getFontMetrics() {
        AppMethodBeat.i(29081);
        if (this.displayNamePaint == null) {
            this.displayNamePaint = generateOnePaint();
        }
        if (this.fm == null) {
            this.fm = this.displayNamePaint.getFontMetrics();
        }
        FontMetrics fontMetrics = this.fm;
        AppMethodBeat.o(29081);
        return fontMetrics;
    }

    public void setDescription(String str) {
        AppMethodBeat.i(29082);
        this.description = str;
        if (this.descriptionPaint == null) {
            this.descriptionPaint = generateDescriptionPaint();
            this.descriptionFontMetrics = this.descriptionPaint.getFontMetrics();
        }
        AppMethodBeat.o(29082);
    }

    public float getNickNameSize() {
        return this.NAME_TEXT_SIZE;
    }

    public CharSequence getNickName() {
        return this.nickName;
    }

    public float getDesiredWidth(CharSequence charSequence, TextPaint textPaint) {
        AppMethodBeat.i(29083);
        float desiredWidth;
        if (charSequence instanceof Spanned) {
            desiredWidth = Layout.getDesiredWidth(charSequence, textPaint);
            AppMethodBeat.o(29083);
            return desiredWidth;
        }
        if (charSequence == null) {
            ab.w(TAG, "source is null, set it empty.");
            charSequence = "";
        }
        desiredWidth = textPaint.measureText(charSequence, 0, charSequence.length());
        AppMethodBeat.o(29083);
        return desiredWidth;
    }

    public void updatePositionFlag() {
        AppMethodBeat.i(29084);
        this.needUpdatePostion = true;
        if (this.needInvaildate) {
            invalidate();
            this.needInvaildate = false;
        }
        AppMethodBeat.o(29084);
    }

    public void updatePosition() {
        AppMethodBeat.i(29085);
        if (this.needUpdatePostion) {
            this.nickNameWidth = (getTextAreaWidth() - getPaddingLeft()) - this.NAME_RIGHT_PADDING;
            if (((int) getDesiredWidth(this.nickName, this.displayNamePaint)) > this.nickNameWidth) {
                this.destNickName = TextUtils.ellipsize(this.nickName, this.displayNamePaint, (float) this.nickNameWidth, TruncateAt.END);
            } else {
                this.destNickName = this.nickName;
                this.nickNameWidth = (int) getDesiredWidth(this.destNickName, this.displayNamePaint);
            }
            if (this.nickName instanceof Spanned) {
                this.nickNamelayout = new StaticLayout(this.destNickName, this.displayNamePaint, getWidth(), Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
                this.nickNameHeight = this.nickNamelayout.getHeight();
            } else {
                this.nickNamelayout = null;
                FontMetrics fontMetrics = getFontMetrics();
                this.nickNameHeight = ((int) Math.ceil((double) (fontMetrics.descent - fontMetrics.top))) + 2;
            }
            updateDrawBounds();
            this.needUpdatePostion = false;
            AppMethodBeat.o(29085);
            return;
        }
        AppMethodBeat.o(29085);
    }

    private void updateDrawableBounds() {
        if (this.avatarDrawable == null) {
        }
    }

    public void updateDrawBounds() {
        AppMethodBeat.i(29086);
        updateDrawableBounds();
        AppMethodBeat.o(29086);
    }

    public int getTextAreaWidth() {
        AppMethodBeat.i(29087);
        int measuredWidth = (getMeasuredWidth() - this.AVATAR_LAYOUT_WIDTH) - this.AVATAR_PADDING;
        AppMethodBeat.o(29087);
        return measuredWidth;
    }

    public int fromDPToPix(Context context, int i) {
        AppMethodBeat.i(29088);
        int round = Math.round(getDensity(context) * ((float) i));
        AppMethodBeat.o(29088);
        return round;
    }

    public float getDensity(Context context) {
        AppMethodBeat.i(29089);
        if (context == null) {
            context = getContext();
        }
        if (this.density < 0.0f) {
            this.density = context.getResources().getDisplayMetrics().density;
        }
        float f = this.density;
        AppMethodBeat.o(29089);
        return f;
    }

    public void setMaskBitmap(Bitmap bitmap) {
        AppMethodBeat.i(29090);
        this.needMask = new BitmapDrawable(getResources(), bitmap);
        AppMethodBeat.o(29090);
    }

    public void setImageDrawable(Drawable drawable) {
        AppMethodBeat.i(29091);
        this.avatarDrawable = drawable;
        if (drawable != null) {
            this.avatarDrawable.setCallback(this);
        }
        AppMethodBeat.o(29091);
    }

    public Drawable getDrawable() {
        return this.avatarDrawable;
    }

    public void resumeAvatarLoad() {
        AppMethodBeat.i(29092);
        if (this.avatarDrawable != null) {
            ((b) this.avatarDrawable).diY();
        }
        AppMethodBeat.o(29092);
    }

    public void stopAvatarLoad() {
        AppMethodBeat.i(29093);
        if (this.avatarDrawable != null) {
            ((b) this.avatarDrawable).diX();
        }
        AppMethodBeat.o(29093);
    }

    public void onScrollStateChanged(boolean z) {
        AppMethodBeat.i(29094);
        if (z) {
            stopAvatarLoad();
            AppMethodBeat.o(29094);
            return;
        }
        resumeAvatarLoad();
        AppMethodBeat.o(29094);
    }

    public void invalidateDrawable(Drawable drawable) {
        AppMethodBeat.i(29095);
        invalidate();
        AppMethodBeat.o(29095);
    }

    public static int dip2px(Context context, float f) {
        AppMethodBeat.i(29096);
        int i = (int) ((context.getResources().getDisplayMetrics().density * f) + 0.5f);
        AppMethodBeat.o(29096);
        return i;
    }

    /* Access modifiers changed, original: protected */
    public void drawableStateChanged() {
        AppMethodBeat.i(29097);
        updateTextColors();
        super.drawableStateChanged();
        AppMethodBeat.o(29097);
    }

    public void updateTextColors() {
        AppMethodBeat.i(29098);
        if (this.nickNameTextColor != null) {
            int colorForState = this.nickNameTextColor.getColorForState(getDrawableState(), 0);
            if (colorForState != this.nickNameCurrentTextColor) {
                this.nickNameCurrentTextColor = colorForState;
                if (this.displayNamePaint == null) {
                    this.displayNamePaint = generateOnePaint();
                }
                this.displayNamePaint.setColor(this.nickNameCurrentTextColor);
            }
        }
        AppMethodBeat.o(29098);
    }

    private TextPaint generateOnePaint() {
        AppMethodBeat.i(29099);
        TextPaint textPaint = new TextPaint();
        textPaint.setAntiAlias(true);
        textPaint.setTextSize(this.NAME_TEXT_SIZE);
        textPaint.setColor(getResources().getColor(R.color.w4));
        AppMethodBeat.o(29099);
        return textPaint;
    }

    private TextPaint generateDescriptionPaint() {
        AppMethodBeat.i(29100);
        TextPaint textPaint = new TextPaint();
        textPaint.setAntiAlias(true);
        textPaint.setTextSize(this.DESCRIPTION_TEXT_SIZE);
        textPaint.setColor(getResources().getColor(R.color.s0));
        AppMethodBeat.o(29100);
        return textPaint;
    }

    public void doInvalidate() {
        AppMethodBeat.i(29101);
        invalidate();
        AppMethodBeat.o(29101);
    }

    @TargetApi(14)
    public void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        AppMethodBeat.i(29102);
        super.onPopulateAccessibilityEvent(accessibilityEvent);
        Object contentDescription = getContentDescription();
        if (bo.isNullOrNil((String) contentDescription)) {
            contentDescription = this.nickName;
        }
        accessibilityEvent.getText().add(contentDescription);
        AppMethodBeat.o(29102);
    }

    private void installAccessibilityDelegate() {
        AppMethodBeat.i(29103);
        s.a((View) this, new android.support.v4.view.a() {
            public final void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
                AppMethodBeat.i(29076);
                super.onPopulateAccessibilityEvent(view, accessibilityEvent);
                Object contentDescription = AddressView.this.getContentDescription();
                if (bo.isNullOrNil((String) contentDescription)) {
                    contentDescription = AddressView.this.nickName;
                }
                accessibilityEvent.getText().add(contentDescription);
                AppMethodBeat.o(29076);
            }

            public final void onInitializeAccessibilityNodeInfo(View view, android.support.v4.view.a.b bVar) {
                AppMethodBeat.i(29077);
                super.onInitializeAccessibilityNodeInfo(view, bVar);
                CharSequence contentDescription = AddressView.this.getContentDescription();
                if (bo.isNullOrNil((String) contentDescription)) {
                    contentDescription = AddressView.this.nickName;
                }
                bVar.setText(contentDescription);
                AppMethodBeat.o(29077);
            }
        });
        AppMethodBeat.o(29103);
    }

    @TargetApi(14)
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        AppMethodBeat.i(29104);
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        CharSequence contentDescription = getContentDescription();
        if (bo.isNullOrNil((String) contentDescription)) {
            contentDescription = this.nickName;
        }
        accessibilityNodeInfo.setText(contentDescription);
        AppMethodBeat.o(29104);
    }
}
