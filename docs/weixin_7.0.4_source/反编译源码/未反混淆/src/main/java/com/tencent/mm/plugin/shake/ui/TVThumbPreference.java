package com.tencent.mm.plugin.shake.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.platformtools.v;
import com.tencent.mm.platformtools.x;
import com.tencent.mm.platformtools.x.a;
import com.tencent.mm.plugin.shake.e.b;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import java.util.List;

public class TVThumbPreference extends Preference implements a {
    f iFE;
    private ImageView qwI;
    private ImageView qwJ;
    private ImageView qwK;
    List<String> qwL;

    public TVThumbPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(24939);
        this.qwL = null;
        setLayoutResource(R.layout.b0y);
        setWidgetLayoutResource(0);
        x.a((a) this);
        AppMethodBeat.o(24939);
    }

    public TVThumbPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TVThumbPreference(Context context) {
        this(context, null);
    }

    public final View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.i(24940);
        View onCreateView = super.onCreateView(viewGroup);
        AppMethodBeat.o(24940);
        return onCreateView;
    }

    public final void onBindView(View view) {
        AppMethodBeat.i(24941);
        super.onBindView(view);
        this.qwI = (ImageView) view.findViewById(R.id.ezk);
        this.qwJ = (ImageView) view.findViewById(R.id.ezl);
        this.qwK = (ImageView) view.findViewById(R.id.ezm);
        if (this.qwL != null) {
            if (this.qwL.size() <= 0) {
                AppMethodBeat.o(24941);
                return;
            }
            v bVar = new b((String) this.qwL.get(0));
            this.qwI.setTag(bVar.anL());
            Bitmap a = x.a(bVar);
            if (!(a == null || a.isRecycled())) {
                this.qwI.setImageBitmap(a);
            }
            this.qwI.setVisibility(0);
            if (1 >= this.qwL.size()) {
                AppMethodBeat.o(24941);
                return;
            }
            bVar = new b((String) this.qwL.get(1));
            this.qwJ.setTag(bVar.anL());
            a = x.a(bVar);
            if (!(a == null || a.isRecycled())) {
                this.qwJ.setImageBitmap(a);
            }
            this.qwJ.setVisibility(0);
            if (2 >= this.qwL.size()) {
                AppMethodBeat.o(24941);
                return;
            }
            bVar = new b((String) this.qwL.get(2));
            this.qwK.setTag(bVar.anL());
            a = x.a(bVar);
            if (!(a == null || a.isRecycled())) {
                this.qwK.setImageBitmap(a);
            }
            this.qwK.setVisibility(0);
        }
        AppMethodBeat.o(24941);
    }

    public final void m(String str, final Bitmap bitmap) {
        AppMethodBeat.i(24942);
        if (str == null || bitmap == null || bitmap.isRecycled()) {
            AppMethodBeat.o(24942);
        } else if (this.qwI != null && this.qwI.getTag() != null && str.equals((String) this.qwI.getTag())) {
            this.qwI.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(24936);
                    TVThumbPreference.this.qwI.setImageBitmap(bitmap);
                    if (TVThumbPreference.this.iFE != null) {
                        TVThumbPreference.this.iFE.notifyDataSetChanged();
                    }
                    AppMethodBeat.o(24936);
                }
            });
            AppMethodBeat.o(24942);
        } else if (this.qwJ == null || this.qwJ.getTag() == null || !str.equals((String) this.qwJ.getTag())) {
            if (!(this.qwK == null || this.qwK.getTag() == null || !str.equals((String) this.qwK.getTag()))) {
                this.qwK.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(24938);
                        TVThumbPreference.this.qwK.setImageBitmap(bitmap);
                        if (TVThumbPreference.this.iFE != null) {
                            TVThumbPreference.this.iFE.notifyDataSetChanged();
                        }
                        AppMethodBeat.o(24938);
                    }
                });
            }
            AppMethodBeat.o(24942);
        } else {
            this.qwJ.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(24937);
                    TVThumbPreference.this.qwJ.setImageBitmap(bitmap);
                    if (TVThumbPreference.this.iFE != null) {
                        TVThumbPreference.this.iFE.notifyDataSetChanged();
                    }
                    AppMethodBeat.o(24937);
                }
            });
            AppMethodBeat.o(24942);
        }
    }
}
