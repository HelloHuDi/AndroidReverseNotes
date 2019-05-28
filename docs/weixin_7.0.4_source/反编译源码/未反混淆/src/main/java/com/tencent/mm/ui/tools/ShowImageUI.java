package com.tencent.mm.ui.tools;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery.LayoutParams;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.af.j.b;
import com.tencent.mm.bp.d;
import com.tencent.mm.g.a.cl;
import com.tencent.mm.g.a.dq;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.v;
import com.tencent.mm.platformtools.x;
import com.tencent.mm.plugin.gif.MMAnimateView;
import com.tencent.mm.plugin.gif.f;
import com.tencent.mm.plugin.gif.k;
import com.tencent.mm.pluginsdk.model.e;
import com.tencent.mm.pluginsdk.ui.tools.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.r;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.ChattingSendDataToDeviceUI;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import java.util.LinkedList;
import java.util.List;

public class ShowImageUI extends MMActivity {
    private MMGestureGallery kkn;
    private boolean zHE;
    private a zHF;
    private boolean zHG;

    class a extends BaseAdapter {
        String imagePath;

        private a() {
        }

        /* synthetic */ a(ShowImageUI showImageUI, byte b) {
            this();
        }

        public final int getCount() {
            return 1;
        }

        public final Object getItem(int i) {
            return null;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            AppMethodBeat.i(34995);
            if (r.amo(this.imagePath)) {
                Context context = viewGroup.getContext();
                String str = this.imagePath;
                f fVar = new f(str);
                if (view == null || !(view instanceof MMAnimateView)) {
                    view = new MMAnimateView(context);
                } else {
                    MMAnimateView mMAnimateView = (MMAnimateView) view;
                }
                view.eE(str, str);
                view.a(str, new k() {
                    public final void invalidate() {
                        AppMethodBeat.i(34994);
                        view.invalidate();
                        AppMethodBeat.o(34994);
                    }
                });
                view.stop();
                view.start();
                AppMethodBeat.o(34995);
            } else {
                Bitmap vv = x.vv(this.imagePath);
                if (vv == null) {
                    ab.w("MicroMsg.ShowImageUI", "get image fail");
                    if (view == null || (view instanceof MultiTouchImageView)) {
                        view = View.inflate(viewGroup.getContext(), R.layout.asz, null);
                    }
                    ((ImageView) view.findViewById(R.id.aga)).setImageResource(R.raw.download_image_icon);
                    view.setLayoutParams(new LayoutParams(-1, -1));
                    AppMethodBeat.o(34995);
                } else {
                    Context context2 = viewGroup.getContext();
                    if (view == null || !(view instanceof MultiTouchImageView)) {
                        view = new MultiTouchImageView(context2, vv.getWidth(), vv.getHeight());
                    } else {
                        MultiTouchImageView view2 = (MultiTouchImageView) view2;
                        view2.bW(vv.getWidth(), vv.getHeight());
                    }
                    view2.setLayoutParams(new LayoutParams(-1, -1));
                    view2.setImageBitmap(vv);
                    view2.setMaxZoomDoubleTab(true);
                    AppMethodBeat.o(34995);
                }
            }
            return view2;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public final int getLayoutId() {
        return R.layout.asy;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(34996);
        super.onCreate(bundle);
        String stringExtra = getIntent().getStringExtra("key_title");
        if (!bo.isNullOrNil(stringExtra)) {
            setMMTitle(stringExtra);
        }
        this.zHE = getIntent().getBooleanExtra("key_favorite", false);
        this.zHG = getIntent().getBooleanExtra("show_menu", true);
        this.kkn = (MMGestureGallery) findViewById(R.id.adi);
        this.kkn.setVerticalFadingEdgeEnabled(false);
        this.kkn.setHorizontalFadingEdgeEnabled(false);
        this.zHF = new a(this, (byte) 0);
        this.zHF.imagePath = getIntent().getStringExtra("key_image_path");
        this.kkn.setAdapter(this.zHF);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(34991);
                ShowImageUI.this.finish();
                AppMethodBeat.o(34991);
                return true;
            }
        });
        if (this.zHG) {
            addIconOptionMenu(0, R.raw.ofm_send_icon, new OnMenuItemClickListener() {
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    AppMethodBeat.i(34993);
                    List linkedList = new LinkedList();
                    List linkedList2 = new LinkedList();
                    if (ShowImageUI.this.zHE && d.afj("favorite")) {
                        linkedList2.add(Integer.valueOf(0));
                        linkedList.add(ShowImageUI.this.getString(R.string.dr8));
                        linkedList2.add(Integer.valueOf(1));
                        linkedList.add(ShowImageUI.this.getString(R.string.dcq));
                        linkedList2.add(Integer.valueOf(2));
                        linkedList.add(ShowImageUI.this.getString(R.string.dwz));
                    } else {
                        linkedList2.add(Integer.valueOf(0));
                        linkedList.add(ShowImageUI.this.getString(R.string.dr8));
                        linkedList2.add(Integer.valueOf(2));
                        linkedList.add(ShowImageUI.this.getString(R.string.dwz));
                    }
                    dq dqVar = new dq();
                    dqVar.cxc.cvx = ShowImageUI.this.getIntent().getLongExtra("key_message_id", -1);
                    com.tencent.mm.sdk.b.a.xxA.m(dqVar);
                    if (dqVar.cxd.cwB) {
                        linkedList2.add(Integer.valueOf(3));
                        linkedList.add(ShowImageUI.this.getString(R.string.amc));
                    }
                    h.a(ShowImageUI.this, "", linkedList, linkedList2, "", false, new h.d() {
                        public final void bV(int i, int i2) {
                            AppMethodBeat.i(34992);
                            switch (i2) {
                                case 0:
                                    ShowImageUI.b(ShowImageUI.this);
                                    AppMethodBeat.o(34992);
                                    return;
                                case 1:
                                    ShowImageUI showImageUI = ShowImageUI.this;
                                    cl clVar = new cl();
                                    long longExtra = showImageUI.getIntent().getLongExtra("key_message_id", -1);
                                    if (-1 == longExtra) {
                                        ab.w("MicroMsg.ShowImageUI", "msg id error, try fav simple data");
                                        e.a(clVar, showImageUI.getIntent().getIntExtra("key_favorite_source_type", 1), showImageUI.getIntent().getStringExtra("key_image_path"));
                                    } else {
                                        e.a(clVar, longExtra);
                                    }
                                    clVar.cvA.activity = showImageUI;
                                    com.tencent.mm.sdk.b.a.xxA.m(clVar);
                                    AppMethodBeat.o(34992);
                                    return;
                                case 2:
                                    ShowImageUI.c(ShowImageUI.this);
                                    AppMethodBeat.o(34992);
                                    return;
                                case 3:
                                    ShowImageUI.d(ShowImageUI.this);
                                    break;
                            }
                            AppMethodBeat.o(34992);
                        }
                    });
                    AppMethodBeat.o(34993);
                    return true;
                }
            });
        }
        AppMethodBeat.o(34996);
    }

    static /* synthetic */ void b(ShowImageUI showImageUI) {
        AppMethodBeat.i(34997);
        String stringExtra = showImageUI.getIntent().getStringExtra("key_image_path");
        int intExtra = showImageUI.getIntent().getIntExtra("key_compress_type", 0);
        long longExtra = showImageUI.getIntent().getLongExtra("key_message_id", -1);
        Intent intent = new Intent(showImageUI, MsgRetransmitUI.class);
        intent.putExtra("Retr_File_Name", stringExtra);
        intent.putExtra("Retr_Msg_Id", longExtra);
        aw.ZK();
        bi jf = c.XO().jf(longExtra);
        b me = b.me(jf.field_content);
        if (r.amo(stringExtra) || (jf.bAA() && me != null && me.type == 2)) {
            intent.putExtra("Retr_Msg_Type", 2);
            intent.putExtra("Retr_Msg_content", jf.field_content);
            if (me != null && me.type == 2) {
                stringExtra = v.nW("msg_" + jf.field_msgSvrId);
                v.Zp().y(stringExtra, true).j("prePublishId", "msg_" + jf.field_msgSvrId);
                intent.putExtra("reportSessionId", stringExtra);
            }
        } else {
            intent.putExtra("Retr_Msg_Type", 0);
        }
        intent.putExtra("Retr_Compress_Type", intExtra);
        showImageUI.startActivity(intent);
        AppMethodBeat.o(34997);
    }

    static /* synthetic */ void c(ShowImageUI showImageUI) {
        AppMethodBeat.i(34998);
        n.j(showImageUI.getIntent().getStringExtra("key_image_path"), showImageUI);
        AppMethodBeat.o(34998);
    }

    static /* synthetic */ void d(ShowImageUI showImageUI) {
        AppMethodBeat.i(34999);
        long longExtra = showImageUI.getIntent().getLongExtra("key_message_id", -1);
        Intent intent = new Intent(showImageUI, ChattingSendDataToDeviceUI.class);
        intent.putExtra("Retr_Msg_Id", longExtra);
        showImageUI.startActivity(intent);
        AppMethodBeat.o(34999);
    }
}
