package com.tencent.p177mm.plugin.game.p433ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p178a.C1177f;
import com.tencent.p177mm.plugin.game.model.C28229n;
import com.tencent.p177mm.plugin.game.model.C28229n.C28233i;
import com.tencent.p177mm.plugin.game.model.C43192o;
import com.tencent.p177mm.plugin.game.model.C43192o.C12173a;
import com.tencent.p177mm.plugin.game.p428f.C28203e;
import com.tencent.p177mm.plugin.game.p428f.C28203e.C20965b;
import com.tencent.p177mm.plugin.game.p428f.C28203e.C28207a.C12125a;
import com.tencent.p177mm.pluginsdk.p597ui.C40459a.C40460b;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.game.ui.GameMessageListUserIconView */
public class GameMessageListUserIconView extends LinearLayout {
    private Context mContext;
    private C43192o nkO;
    private C1177f<String, Bitmap> nkP;

    public GameMessageListUserIconView(Context context) {
        super(context);
        AppMethodBeat.m2504i(112091);
        this.mContext = context;
        init();
        AppMethodBeat.m2505o(112091);
    }

    public GameMessageListUserIconView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(112092);
        this.mContext = context;
        init();
        AppMethodBeat.m2505o(112092);
    }

    /* Access modifiers changed, original: protected */
    public void onFinishInflate() {
        AppMethodBeat.m2504i(112093);
        super.onFinishInflate();
        init();
        AppMethodBeat.m2505o(112093);
    }

    private void init() {
        AppMethodBeat.m2504i(112094);
        if (this.nkO == null) {
            this.nkO = new C43192o(this.mContext);
        }
        AppMethodBeat.m2505o(112094);
    }

    public void setSourceScene(int i) {
        AppMethodBeat.m2504i(112095);
        if (this.nkO != null) {
            this.nkO.mXC = i;
            AppMethodBeat.m2505o(112095);
            return;
        }
        this.nkO = new C43192o(this.mContext, i);
        AppMethodBeat.m2505o(112095);
    }

    /* renamed from: a */
    public final void mo46135a(C28229n c28229n, LinkedList<C28233i> linkedList, C1177f<String, Bitmap> c1177f) {
        AppMethodBeat.m2504i(112096);
        if (c28229n == null || C5046bo.m7548ek(linkedList)) {
            setVisibility(8);
            AppMethodBeat.m2505o(112096);
            return;
        }
        this.nkP = c1177f;
        setVisibility(0);
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(C25738R.dimen.f9933kl);
        int dimensionPixelSize2 = this.mContext.getResources().getDimensionPixelSize(C25738R.dimen.f9723do);
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
                C28233i c28233i = (C28233i) linkedList.get(i);
                String str;
                Bitmap bitmap;
                if (C5046bo.isNullOrNil(c28233i.mXu)) {
                    str = c28233i.userName;
                    if (C5046bo.isNullOrNil(str)) {
                        C40460b.m69434b(imageView2, str);
                    } else if (this.nkP.mo4405aj(str)) {
                        bitmap = (Bitmap) this.nkP.get(str);
                        if (bitmap == null || bitmap.isRecycled()) {
                            m44829e(imageView2, str);
                        } else {
                            imageView2.setImageBitmap(bitmap);
                        }
                    } else {
                        m44829e(imageView2, str);
                    }
                } else {
                    str = c28233i.mXu;
                    if (this.nkP.mo4405aj(str)) {
                        bitmap = (Bitmap) this.nkP.get(str);
                        if (bitmap == null || bitmap.isRecycled()) {
                            m44830g(imageView2, str);
                        } else {
                            imageView2.setImageBitmap(bitmap);
                        }
                    } else {
                        m44830g(imageView2, str);
                    }
                }
                if (C5046bo.isNullOrNil(c28233i.mXx)) {
                    imageView2.setEnabled(false);
                } else {
                    imageView2.setTag(new C12173a(c28229n, c28233i.mXx, 6));
                    imageView2.setEnabled(true);
                }
            } else {
                imageView2.setVisibility(8);
            }
        }
        AppMethodBeat.m2505o(112096);
    }

    /* renamed from: g */
    private void m44830g(ImageView imageView, final String str) {
        AppMethodBeat.m2504i(112097);
        C12125a c12125a = new C12125a();
        c12125a.ePF = false;
        C28203e.bFH().mo46099a(imageView, str, c12125a.bFI(), new C20965b() {
            /* renamed from: a */
            public final void mo36291a(View view, Bitmap bitmap) {
                AppMethodBeat.m2504i(112090);
                if (!(bitmap == null || bitmap.isRecycled())) {
                    GameMessageListUserIconView.this.nkP.put(str, bitmap);
                }
                AppMethodBeat.m2505o(112090);
            }
        });
        AppMethodBeat.m2505o(112097);
    }

    /* renamed from: e */
    private void m44829e(ImageView imageView, String str) {
        AppMethodBeat.m2504i(112098);
        Bitmap j = C28203e.bFH().mo46102j(imageView, str);
        if (j != null) {
            this.nkP.put(str, j);
        }
        AppMethodBeat.m2505o(112098);
    }
}
