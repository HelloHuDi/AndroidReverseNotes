package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.a.f;
import com.tencent.mm.plugin.game.f.e;
import com.tencent.mm.plugin.game.model.n;
import com.tencent.mm.plugin.game.model.n.i;
import com.tencent.mm.plugin.game.model.o;
import com.tencent.mm.plugin.game.model.o.a;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.LinkedList;

public class GameMessageListUserIconView extends LinearLayout {
    private Context mContext;
    private o nkO;
    private f<String, Bitmap> nkP;

    public GameMessageListUserIconView(Context context) {
        super(context);
        AppMethodBeat.i(112091);
        this.mContext = context;
        init();
        AppMethodBeat.o(112091);
    }

    public GameMessageListUserIconView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(112092);
        this.mContext = context;
        init();
        AppMethodBeat.o(112092);
    }

    /* Access modifiers changed, original: protected */
    public void onFinishInflate() {
        AppMethodBeat.i(112093);
        super.onFinishInflate();
        init();
        AppMethodBeat.o(112093);
    }

    private void init() {
        AppMethodBeat.i(112094);
        if (this.nkO == null) {
            this.nkO = new o(this.mContext);
        }
        AppMethodBeat.o(112094);
    }

    public void setSourceScene(int i) {
        AppMethodBeat.i(112095);
        if (this.nkO != null) {
            this.nkO.mXC = i;
            AppMethodBeat.o(112095);
            return;
        }
        this.nkO = new o(this.mContext, i);
        AppMethodBeat.o(112095);
    }

    public final void a(n nVar, LinkedList<i> linkedList, f<String, Bitmap> fVar) {
        AppMethodBeat.i(112096);
        if (nVar == null || bo.ek(linkedList)) {
            setVisibility(8);
            AppMethodBeat.o(112096);
            return;
        }
        this.nkP = fVar;
        setVisibility(0);
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.kl);
        int dimensionPixelSize2 = this.mContext.getResources().getDimensionPixelSize(R.dimen.f15do);
        LayoutParams layoutParams = new LayoutParams(dimensionPixelSize, dimensionPixelSize);
        layoutParams.rightMargin = dimensionPixelSize2;
        while (getChildCount() < linkedList.size()) {
            ImageView imageView = new ImageView(this.mContext);
            imageView.setLayoutParams(layoutParams);
            imageView.setScaleType(ScaleType.FIT_XY);
            imageView.setOnClickListener(this.nkO);
            addView(imageView);
        }
        for (int i = 0; i < getChildCount(); i++) {
            ImageView imageView2 = (ImageView) getChildAt(i);
            if (i < linkedList.size()) {
                imageView2.setVisibility(0);
                i iVar = (i) linkedList.get(i);
                String str;
                Bitmap bitmap;
                if (bo.isNullOrNil(iVar.mXu)) {
                    str = iVar.userName;
                    if (bo.isNullOrNil(str)) {
                        b.b(imageView2, str);
                    } else if (this.nkP.aj(str)) {
                        bitmap = (Bitmap) this.nkP.get(str);
                        if (bitmap == null || bitmap.isRecycled()) {
                            e(imageView2, str);
                        } else {
                            imageView2.setImageBitmap(bitmap);
                        }
                    } else {
                        e(imageView2, str);
                    }
                } else {
                    str = iVar.mXu;
                    if (this.nkP.aj(str)) {
                        bitmap = (Bitmap) this.nkP.get(str);
                        if (bitmap == null || bitmap.isRecycled()) {
                            g(imageView2, str);
                        } else {
                            imageView2.setImageBitmap(bitmap);
                        }
                    } else {
                        g(imageView2, str);
                    }
                }
                if (bo.isNullOrNil(iVar.mXx)) {
                    imageView2.setEnabled(false);
                } else {
                    imageView2.setTag(new a(nVar, iVar.mXx, 6));
                    imageView2.setEnabled(true);
                }
            } else {
                imageView2.setVisibility(8);
            }
        }
        AppMethodBeat.o(112096);
    }

    private void g(ImageView imageView, final String str) {
        AppMethodBeat.i(112097);
        e.a.a aVar = new e.a.a();
        aVar.ePF = false;
        e.bFH().a(imageView, str, aVar.bFI(), new e.b() {
            public final void a(View view, Bitmap bitmap) {
                AppMethodBeat.i(112090);
                if (!(bitmap == null || bitmap.isRecycled())) {
                    GameMessageListUserIconView.this.nkP.put(str, bitmap);
                }
                AppMethodBeat.o(112090);
            }
        });
        AppMethodBeat.o(112097);
    }

    private void e(ImageView imageView, String str) {
        AppMethodBeat.i(112098);
        Bitmap j = e.bFH().j(imageView, str);
        if (j != null) {
            this.nkP.put(str, j);
        }
        AppMethodBeat.o(112098);
    }
}
