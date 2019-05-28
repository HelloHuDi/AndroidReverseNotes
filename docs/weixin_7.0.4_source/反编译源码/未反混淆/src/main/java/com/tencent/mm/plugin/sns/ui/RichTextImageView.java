package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;

public class RichTextImageView extends LinearLayout {
    private Activity czX;
    private TextView gne;
    private ImageView olT;
    private TextView rii;
    private TextView rmN;
    private boolean rmO = false;
    private String rmP;

    public RichTextImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(38547);
        this.czX = (Activity) context;
        View inflate = inflate(this.czX, R.layout.aw5, this);
        this.rii = (TextView) inflate.findViewById(R.id.d14);
        this.gne = (TextView) inflate.findViewById(R.id.d13);
        this.rmN = (TextView) inflate.findViewById(R.id.el5);
        this.olT = (ImageView) inflate.findViewById(R.id.d11);
        AppMethodBeat.o(38547);
    }

    public void setTitle(String str) {
        AppMethodBeat.i(38548);
        this.gne.setText(str);
        AppMethodBeat.o(38548);
    }

    public void setText(String str) {
        AppMethodBeat.i(38549);
        this.rmO = true;
        if (str == null) {
            str = "";
        }
        this.rmP = str;
        this.rii.setText(this.rmP);
        requestLayout();
        AppMethodBeat.o(38549);
    }

    public void setImage(int i) {
        AppMethodBeat.i(38550);
        this.olT.setImageResource(i);
        AppMethodBeat.o(38550);
    }

    public void setImage(Bitmap bitmap) {
        AppMethodBeat.i(38551);
        this.olT.setImageBitmap(bitmap);
        AppMethodBeat.o(38551);
    }

    public ImageView getImageView() {
        return this.olT;
    }

    public TextView getTitle() {
        return this.gne;
    }

    /* Access modifiers changed, original: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        AppMethodBeat.i(38552);
        super.onLayout(z, i, i2, i3, i4);
        if (!this.rmO) {
            AppMethodBeat.o(38552);
        } else if (this.rmP == null) {
            AppMethodBeat.o(38552);
        } else {
            ab.d("MicroMsg.RichTextImageView", "onLayout  Heighth:" + this.rii.getHeight() + " LineHeight:" + this.rii.getLineHeight());
            int height = this.rii.getHeight() / this.rii.getLineHeight();
            int lineCount = this.rii.getLineCount();
            Rect rect = new Rect();
            int i5 = 0;
            int i6 = 0;
            while (i5 < height) {
                try {
                    this.rii.getLineBounds(i5, rect);
                    i6 += rect.height();
                    if (i6 > this.rii.getHeight()) {
                        break;
                    }
                    i5++;
                } catch (IndexOutOfBoundsException e) {
                }
            }
            if (lineCount >= i5 && this.rmO) {
                if (i5 <= 0) {
                    i5 = 1;
                }
                i5 = this.rii.getLayout().getLineVisibleEnd(i5 - 1);
                StringBuilder append = new StringBuilder("bottomH:").append(this.rmN.getHeight()).append("length");
                String str = this.rmP;
                ab.e("test", append.append(str.substring(i5, str.length()).length()).toString());
                ab.e("test", "bottomH:" + this.rmN.getHeight());
                if (this.rmN.getText().length() > 0) {
                    this.rmN.setVisibility(0);
                    this.rmO = false;
                    new ak().post(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(38546);
                            RichTextImageView.this.rii.setText(RichTextImageView.this.rmP.substring(0, i5));
                            RichTextImageView.this.rmN.setText(RichTextImageView.this.rmP.substring(i5, RichTextImageView.this.rmP.length()));
                            RichTextImageView.this.rmN.invalidate();
                            RichTextImageView.this.rmO = false;
                            ab.e("test", "bottomH:" + RichTextImageView.this.rmN.getHeight());
                            AppMethodBeat.o(38546);
                        }
                    });
                }
                ab.e("test", "bottom:" + i4 + "   mesH:" + this.rmN.getMeasuredHeight());
            }
            AppMethodBeat.o(38552);
        }
    }
}
