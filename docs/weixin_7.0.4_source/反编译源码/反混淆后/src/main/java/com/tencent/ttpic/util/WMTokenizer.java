package com.tencent.ttpic.util;

import android.graphics.Rect;
import android.graphics.RectF;
import android.text.TextPaint;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.BaseUtils;
import com.tencent.ttpic.baseutils.LogUtils;
import java.util.ArrayList;
import java.util.Iterator;

public class WMTokenizer {
    private static final int ALIGN_BOTTOM = 4;
    private static final int ALIGN_CENTER = 1;
    private static final int ALIGN_LEFT = 0;
    private static final int ALIGN_RIGHT = 2;
    private static final int ALIGN_TOP = 3;
    private static final String ELLIPSIZE = "...";
    private static final String STRING_EMPTY = "";
    private static final String TAG = WMTokenizer.class.getSimpleName();
    protected int mAlignMode;
    private float mCharHeight;
    private float mCharWidth;
    private boolean mFitIn;
    protected int mHeight;
    protected TextPaint mPaint;
    protected boolean mSingleLine;
    protected float mSpacingPlus;
    protected String mText;
    private RectF mTextRect;
    private float[] mTextWidths;
    private ArrayList<Token> mTokens = new ArrayList();
    protected boolean mVertical;
    protected int mWidth;

    public class Token {
        public float height;
        public String text;
        public float width;
        /* renamed from: x */
        public float f14339x;
        /* renamed from: y */
        public float f14340y;

        public String toString() {
            return this.text;
        }
    }

    static {
        AppMethodBeat.m2504i(84303);
        AppMethodBeat.m2505o(84303);
    }

    public WMTokenizer(String str, TextPaint textPaint) {
        AppMethodBeat.m2504i(84291);
        this.mText = str;
        this.mPaint = textPaint;
        AppMethodBeat.m2505o(84291);
    }

    public static WMTokenizer from(String str, TextPaint textPaint) {
        AppMethodBeat.m2504i(84292);
        WMTokenizer wMTokenizer = new WMTokenizer(str, textPaint);
        AppMethodBeat.m2505o(84292);
        return wMTokenizer;
    }

    public WMTokenizer setWidth(int i) {
        this.mWidth = i;
        return this;
    }

    public WMTokenizer setHeight(int i) {
        this.mHeight = i;
        return this;
    }

    public WMTokenizer setAlign(String str) {
        AppMethodBeat.m2504i(84293);
        if (!TextUtils.isEmpty(str)) {
            if (str.equals("left")) {
                this.mAlignMode = 0;
            } else if (str.equals("center")) {
                this.mAlignMode = 1;
            } else if (str.equals("right")) {
                this.mAlignMode = 2;
            } else if (str.equals("up")) {
                this.mAlignMode = 3;
            } else if (str.equals("down")) {
                this.mAlignMode = 4;
            }
        }
        AppMethodBeat.m2505o(84293);
        return this;
    }

    public WMTokenizer setVertical(boolean z) {
        this.mVertical = z;
        return this;
    }

    public WMTokenizer setSpacingPlus(float f) {
        this.mSpacingPlus = f;
        return this;
    }

    public WMTokenizer setSingleLine(boolean z) {
        this.mSingleLine = z;
        return this;
    }

    public void tokenizer() {
        AppMethodBeat.m2504i(84294);
        this.mTokens.clear();
        this.mCharWidth = 0.0f;
        this.mTextWidths = new float[this.mText.length()];
        this.mPaint.getTextWidths(this.mText, this.mTextWidths);
        for (float f : this.mTextWidths) {
            if (f > this.mCharWidth) {
                this.mCharWidth = f;
            }
        }
        Rect rect = new Rect();
        this.mPaint.getTextBounds(this.mText, 0, this.mText.length(), rect);
        this.mCharHeight = (float) rect.height();
        if (this.mVertical) {
            tokenizerVertical();
            AppMethodBeat.m2505o(84294);
            return;
        }
        tokenizeHorizontal();
        AppMethodBeat.m2505o(84294);
    }

    private void tokenizeHorizontal() {
        AppMethodBeat.m2504i(84295);
        if (this.mSingleLine) {
            tokenizerHorizontalSingleRow();
            AppMethodBeat.m2505o(84295);
            return;
        }
        tokenizerHorizontalMultiRow();
        AppMethodBeat.m2505o(84295);
    }

    private void tokenizerHorizontalSingleRow() {
        boolean z;
        AppMethodBeat.m2504i(84296);
        if (this.mWidth <= 0 || TextUtils.isEmpty(this.mText)) {
            LogUtils.m50202e(TAG, "ERROR => mWidth <= 0 || TextUtils.isEmpty(mText)");
        }
        float f = 0.0f;
        int i = 0;
        while (i < this.mText.length()) {
            f += this.mTextWidths[i];
            if (f > ((float) this.mWidth)) {
                f -= this.mTextWidths[i];
                i--;
                z = true;
                break;
            }
            f += this.mSpacingPlus;
            i++;
        }
        z = false;
        if ((this.mHeight <= 0 || ((float) this.mHeight) >= this.mCharHeight) && !z) {
            this.mFitIn = true;
        } else {
            this.mFitIn = false;
        }
        Token token = new Token();
        if (i >= this.mText.length() || i <= 2) {
            token.text = this.mText;
        } else {
            String str = this.mText.substring(0, i - 2) + ELLIPSIZE;
            if (TextUtils.isEmpty(str)) {
                LogUtils.m50202e(TAG, "ERROR => TextUtils.isEmpty(text2Draw)");
            }
            token.text = str;
        }
        token.width = f;
        token.height = this.mCharHeight;
        this.mTokens.add(token);
        LogUtils.m50199d(TAG, "mTokens => " + this.mTokens.toString());
        AppMethodBeat.m2505o(84296);
    }

    private void tokenizerHorizontalMultiRow() {
        AppMethodBeat.m2504i(84297);
        if (this.mWidth <= 0 || TextUtils.isEmpty(this.mText)) {
            LogUtils.m50202e(TAG, "ERROR => mWidth <= 0 || TextUtils.isEmpty(mText)");
        }
        float f = 0.0f;
        int i = 0;
        int i2 = 0;
        while (i2 < this.mText.length()) {
            f += this.mTextWidths[i2];
            if (f > ((float) this.mWidth)) {
                int i3;
                float f2 = f - this.mTextWidths[i2];
                int i4 = i2 - 1;
                float f3 = f2;
                while (i4 > i) {
                    if (isDelimiter(this.mText.charAt(i4))) {
                        i3 = i4 + 1;
                        break;
                    } else {
                        i4--;
                        f3 -= this.mTextWidths[i4];
                    }
                }
                i3 = i2;
                String substring = this.mText.substring(i, i3);
                if (TextUtils.isEmpty(substring)) {
                    LogUtils.m50202e(TAG, "ERROR => TextUtils.isEmpty(textRow)");
                }
                Token token = new Token();
                token.text = substring;
                token.width = f3;
                token.height = this.mCharHeight;
                this.mTokens.add(token);
                f = 0.0f;
                i = i3;
                i2 = i3;
            } else {
                f += this.mSpacingPlus;
                i2++;
            }
        }
        if (i < this.mText.length()) {
            Token token2 = new Token();
            token2.text = this.mText.substring(i);
            token2.width = f;
            token2.height = this.mCharHeight;
            this.mTokens.add(token2);
        }
        if (this.mHeight <= 0 || ((float) this.mTokens.size()) * this.mCharHeight <= ((float) this.mHeight)) {
            this.mFitIn = true;
        } else {
            this.mFitIn = false;
        }
        if (this.mHeight > 0 && ((float) this.mHeight) >= this.mCharHeight) {
            int i5 = (int) (((float) this.mHeight) / this.mCharHeight);
            if (this.mTokens.size() > i5) {
                Token token3 = (Token) this.mTokens.get(i5 - 1);
                if (token3.text.length() > 3) {
                    token3.text = token3.text.substring(0, token3.text.length() - 3) + ELLIPSIZE;
                }
            }
            while (this.mTokens.size() > i5) {
                this.mTokens.remove(i5);
            }
        }
        LogUtils.m50199d(TAG, "mTokens => " + this.mTokens.toString());
        AppMethodBeat.m2505o(84297);
    }

    private void tokenizerVertical() {
        AppMethodBeat.m2504i(84298);
        if (this.mSingleLine) {
            tokenizerVerticalSingleColumn();
            AppMethodBeat.m2505o(84298);
            return;
        }
        tokenizerVerticalMultiColumn();
        AppMethodBeat.m2505o(84298);
    }

    private void tokenizerVerticalSingleColumn() {
        int length;
        AppMethodBeat.m2504i(84299);
        if (this.mHeight <= 0 || TextUtils.isEmpty(this.mText)) {
            LogUtils.m50202e(TAG, "ERROR => mHeight <= 0 || TextUtils.isEmpty(mText)");
        }
        Token token = new Token();
        token.text = this.mText;
        int i = (int) (((float) this.mHeight) / this.mCharHeight);
        if ((this.mWidth <= 0 || ((float) this.mWidth) >= this.mCharWidth) && i > this.mText.length()) {
            this.mFitIn = true;
        } else {
            this.mFitIn = false;
        }
        if (i < this.mText.length()) {
            String substring = this.mText.substring(0, i);
            if (i > 3) {
                substring = substring.substring(0, i - 3) + ELLIPSIZE;
            } else {
                LogUtils.m50202e(TAG, "countColumn <= 3");
            }
            token.text = substring;
        }
        token.width = this.mCharWidth;
        if (i > this.mText.length()) {
            length = this.mText.length();
        } else {
            length = i;
        }
        token.height = ((float) length) * this.mCharHeight;
        this.mTokens.add(token);
        LogUtils.m50199d(TAG, "mTokens => " + this.mTokens.toString());
        AppMethodBeat.m2505o(84299);
    }

    private void tokenizerVerticalMultiColumn() {
        AppMethodBeat.m2504i(84300);
        if (this.mHeight <= 0 || TextUtils.isEmpty(this.mText)) {
            LogUtils.m50202e(TAG, "ERROR => mHeight <= 0 || TextUtils.isEmpty(mText)");
        }
        float f = 0.0f;
        int i = 0;
        int i2 = 0;
        while (i2 < this.mText.length()) {
            f += this.mCharHeight;
            if (f > ((float) this.mHeight)) {
                int i3;
                float f2 = f - this.mCharHeight;
                int i4 = i2 - 1;
                float f3 = f2;
                while (i4 > i) {
                    if (isDelimiter(this.mText.charAt(i4))) {
                        i3 = i4 + 1;
                        break;
                    } else {
                        i4--;
                        f3 -= this.mCharHeight;
                    }
                }
                i3 = i2;
                String substring = this.mText.substring(i, i3);
                if (TextUtils.isEmpty(substring)) {
                    LogUtils.m50202e(TAG, "ERROR => TextUtils.isEmpty(textColumn)");
                }
                Token token = new Token();
                token.text = substring;
                token.width = this.mCharWidth;
                token.height = f3;
                this.mTokens.add(token);
                f = 0.0f;
                i = i3;
                i2 = i3;
            } else {
                i2++;
            }
        }
        if (i < this.mText.length()) {
            Token token2 = new Token();
            token2.text = this.mText.substring(i);
            token2.width = this.mCharWidth;
            token2.height = f;
            this.mTokens.add(token2);
        }
        if (this.mWidth <= 0 || ((float) this.mTokens.size()) * this.mCharWidth <= ((float) this.mWidth)) {
            this.mFitIn = true;
        } else {
            this.mFitIn = false;
        }
        if (this.mWidth > 0 && ((float) this.mWidth) >= this.mCharWidth) {
            int i5 = (int) (((float) this.mWidth) / this.mCharWidth);
            if (this.mTokens.size() > i5) {
                Token token3 = (Token) this.mTokens.get(i5 - 1);
                if (token3.text.length() > 3) {
                    token3.text = token3.text.substring(0, token3.text.length() - 3) + ELLIPSIZE;
                }
            }
            while (this.mTokens.size() > i5) {
                this.mTokens.remove(i5);
            }
        }
        LogUtils.m50199d(TAG, "mTokens => " + this.mTokens.toString());
        AppMethodBeat.m2505o(84300);
    }

    public void doLayout() {
        AppMethodBeat.m2504i(84301);
        this.mTextRect = new RectF();
        if (this.mTokens.isEmpty()) {
            AppMethodBeat.m2505o(84301);
            return;
        }
        Iterator it;
        Token token;
        float size;
        float f;
        if (this.mVertical) {
            size = (((float) this.mWidth) - (((float) this.mTokens.size()) * this.mCharWidth)) / 2.0f;
            if (this.mAlignMode == 2) {
                size = ((float) this.mWidth) - (this.mCharWidth * ((float) this.mTokens.size()));
            } else if (this.mAlignMode == 1) {
                size = (((float) this.mWidth) - (this.mCharWidth * ((float) this.mTokens.size()))) / 2.0f;
            }
            it = this.mTokens.iterator();
            while (true) {
                f = size;
                if (it.hasNext()) {
                    token = (Token) it.next();
                    switch (this.mAlignMode) {
                        case 1:
                            token.f14340y = (((float) this.mHeight) - token.height) / 2.0f;
                            break;
                        case 3:
                            token.f14340y = 0.0f;
                            break;
                        case 4:
                            token.f14339x = ((float) this.mHeight) - token.height;
                            break;
                        default:
                            break;
                    }
                    token.f14339x = f;
                    size = token.width + f;
                }
            }
        } else {
            size = (((float) this.mHeight) - (this.mCharHeight * ((float) this.mTokens.size()))) / 2.0f;
            if (this.mAlignMode == 4) {
                size = ((float) this.mHeight) - (this.mCharHeight * ((float) this.mTokens.size()));
            } else if (this.mAlignMode == 1) {
                size = (((float) this.mHeight) - (this.mCharHeight * ((float) this.mTokens.size()))) / 2.0f;
            }
            it = this.mTokens.iterator();
            while (true) {
                f = size;
                if (it.hasNext()) {
                    token = (Token) it.next();
                    switch (this.mAlignMode) {
                        case 0:
                            token.f14339x = 0.0f;
                            break;
                        case 1:
                            token.f14339x = (((float) this.mWidth) - token.width) / 2.0f;
                            break;
                        case 2:
                            token.f14339x = ((float) this.mWidth) - token.width;
                            break;
                        default:
                            break;
                    }
                    token.f14340y = f;
                    size = token.height + f;
                }
            }
        }
        this.mTextRect = new RectF();
        it = this.mTokens.iterator();
        while (it.hasNext()) {
            token = (Token) it.next();
            this.mTextRect.left = this.mTextRect.left <= token.f14339x ? this.mTextRect.left : token.f14339x;
            this.mTextRect.right = this.mTextRect.right >= token.f14339x + token.width ? this.mTextRect.right : token.f14339x + token.width;
            this.mTextRect.top = this.mTextRect.top <= token.f14340y ? this.mTextRect.top : token.f14340y;
            this.mTextRect.bottom = this.mTextRect.bottom >= token.f14340y + token.height ? this.mTextRect.bottom : token.height + token.f14340y;
        }
        AppMethodBeat.m2505o(84301);
    }

    public boolean isFitIn() {
        return this.mFitIn;
    }

    public float getFontHeight() {
        return this.mCharHeight;
    }

    public RectF getTextRect() {
        return this.mTextRect;
    }

    public ArrayList<Token> getTokens() {
        return this.mTokens;
    }

    public Token getToken(int i) {
        AppMethodBeat.m2504i(84302);
        if (BaseUtils.indexOutOfBounds(this.mTokens, i)) {
            AppMethodBeat.m2505o(84302);
            return null;
        }
        Token token = (Token) this.mTokens.get(i);
        AppMethodBeat.m2505o(84302);
        return token;
    }

    private boolean isDelimiter(char c) {
        return c == 10 || c == 13 || c == 9 || c == ' ' || c == ',' || c == '.' || c == 65292 || c == 12290;
    }
}
