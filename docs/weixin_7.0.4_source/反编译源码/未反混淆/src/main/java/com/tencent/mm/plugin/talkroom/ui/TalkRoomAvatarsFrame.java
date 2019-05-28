package com.tencent.mm.plugin.talkroom.ui;

import android.content.Context;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.MMHorList;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;
import java.util.LinkedList;
import java.util.List;

public class TalkRoomAvatarsFrame extends FrameLayout {
    private ak mHandler;
    private String nMN;
    private final int nMz = com.tencent.mm.bz.a.fromDPToPix(null, 58);
    private final int szg = 2000;
    private final int szh = 5;
    private MMHorList szi;
    private a szj;
    private ap szk;

    static class a extends BaseAdapter {
        private Context mContext;
        String nMN;
        List<String> szn = new LinkedList();

        class a {
            public ImageView ejo;
            public TextView ejp;

            a() {
            }
        }

        public a(Context context) {
            AppMethodBeat.i(25895);
            this.mContext = context;
            AppMethodBeat.o(25895);
        }

        public final int indexOf(String str) {
            AppMethodBeat.i(25896);
            int indexOf = this.szn.indexOf(str);
            AppMethodBeat.o(25896);
            return indexOf;
        }

        public final int getCount() {
            AppMethodBeat.i(25897);
            int size = this.szn.size();
            AppMethodBeat.o(25897);
            return size;
        }

        public final Object getItem(int i) {
            AppMethodBeat.i(25898);
            Object obj = this.szn.get(i);
            AppMethodBeat.o(25898);
            return obj;
        }

        public final long getItemId(int i) {
            return 0;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            AppMethodBeat.i(25899);
            String str = (String) this.szn.get(i);
            if (view == null) {
                view = View.inflate(this.mContext, R.layout.aze, null);
                a aVar2 = new a();
                aVar2.ejo = (ImageView) view.findViewById(R.id.evd);
                aVar2.ejp = (TextView) view.findViewById(R.id.eve);
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (a) view.getTag();
            }
            aVar.ejo.setBackgroundResource(str.equals(this.nMN) ? R.drawable.ap8 : 0);
            aVar.ejp.setVisibility(8);
            b.t(aVar.ejo, str);
            AppMethodBeat.o(25899);
            return view;
        }
    }

    static /* synthetic */ void d(TalkRoomAvatarsFrame talkRoomAvatarsFrame) {
        AppMethodBeat.i(25906);
        talkRoomAvatarsFrame.bJk();
        AppMethodBeat.o(25906);
    }

    public TalkRoomAvatarsFrame(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(25900);
        initView();
        AppMethodBeat.o(25900);
    }

    public TalkRoomAvatarsFrame(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(25901);
        initView();
        AppMethodBeat.o(25901);
    }

    private void initView() {
        AppMethodBeat.i(25902);
        inflate(getContext(), R.layout.azd, this);
        this.szi = (MMHorList) findViewById(R.id.evc);
        this.szi.setOverScrollEnabled(true);
        this.szi.setCenterInParent(true);
        this.szi.setItemWidth(this.nMz);
        this.szj = new a(getContext());
        this.szi.setAdapter(this.szj);
        this.mHandler = new ak(Looper.getMainLooper());
        this.szi.setHorListLitener(new com.tencent.mm.ui.base.MMHorList.a() {
            public final void cEF() {
                AppMethodBeat.i(25891);
                TalkRoomAvatarsFrame.this.szk.stopTimer();
                AppMethodBeat.o(25891);
            }

            public final void cEG() {
                AppMethodBeat.i(25892);
                TalkRoomAvatarsFrame.this.szk.ae(FaceGestureDetGLThread.BRIGHTNESS_DURATION, FaceGestureDetGLThread.BRIGHTNESS_DURATION);
                AppMethodBeat.o(25892);
            }

            public final void aQe() {
                AppMethodBeat.i(25893);
                TalkRoomAvatarsFrame.this.mHandler.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(25890);
                        TalkRoomAvatarsFrame.this.szj.notifyDataSetChanged();
                        AppMethodBeat.o(25890);
                    }
                });
                AppMethodBeat.o(25893);
            }
        });
        this.szk = new ap(new com.tencent.mm.sdk.platformtools.ap.a() {
            public final boolean BI() {
                AppMethodBeat.i(25894);
                TalkRoomAvatarsFrame.d(TalkRoomAvatarsFrame.this);
                AppMethodBeat.o(25894);
                return false;
            }
        }, false);
        AppMethodBeat.o(25902);
    }

    public void setMembersList(List<String> list) {
        AppMethodBeat.i(25903);
        if (this.szj == null) {
            AppMethodBeat.o(25903);
            return;
        }
        a aVar = this.szj;
        if (list == null) {
            aVar.szn.clear();
        } else {
            aVar.szn = list;
        }
        aVar.notifyDataSetChanged();
        AppMethodBeat.o(25903);
    }

    public void setCurMemeber(String str) {
        AppMethodBeat.i(25904);
        if (this.szi == null) {
            AppMethodBeat.o(25904);
        } else if (bo.isNullOrNil(this.nMN) && bo.isNullOrNil(str)) {
            AppMethodBeat.o(25904);
        } else if (bo.isNullOrNil(this.nMN) || !this.nMN.equals(str)) {
            this.nMN = str;
            bJk();
            AppMethodBeat.o(25904);
        } else {
            AppMethodBeat.o(25904);
        }
    }

    private void bJk() {
        AppMethodBeat.i(25905);
        this.szj.nMN = this.nMN;
        if (bo.isNullOrNil(this.nMN)) {
            this.szj.notifyDataSetChanged();
            AppMethodBeat.o(25905);
        } else if (this.szi.getIsTouching()) {
            AppMethodBeat.o(25905);
        } else {
            int indexOf = this.szj.indexOf(this.nMN) * this.nMz;
            int currentPosition = this.szi.getCurrentPosition();
            if (indexOf < currentPosition) {
                this.szi.NI(indexOf);
                AppMethodBeat.o(25905);
            } else if (indexOf > currentPosition + (this.nMz * 4)) {
                this.szi.NI(indexOf - (this.nMz * 4));
                AppMethodBeat.o(25905);
            } else {
                this.szj.notifyDataSetChanged();
                AppMethodBeat.o(25905);
            }
        }
    }
}
