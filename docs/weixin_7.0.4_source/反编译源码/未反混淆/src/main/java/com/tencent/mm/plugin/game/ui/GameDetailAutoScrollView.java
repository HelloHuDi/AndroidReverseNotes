package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.e.j;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ap.a;
import java.util.ArrayList;
import java.util.List;

public class GameDetailAutoScrollView extends LinearLayout {
    private int lfO = 0;
    private ap neF = new ap(new a() {
        public final boolean BI() {
            AppMethodBeat.i(111806);
            GameDetailAutoScrollView.a(GameDetailAutoScrollView.this);
            AppMethodBeat.o(111806);
            return true;
        }
    }, true);
    private ArrayList<String> nga = new ArrayList();
    private ViewGroup ngb;
    private TextView ngc;
    private TextView ngd;
    private ViewGroup nge;
    private TextView ngf;
    private TextView ngg;
    private Animation ngh;
    private Animation ngi;

    public GameDetailAutoScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(111807);
        this.ngb = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.a3_, this, false);
        this.ngc = (TextView) this.ngb.findViewById(R.id.c4d);
        this.ngd = (TextView) this.ngb.findViewById(R.id.c4e);
        addView(this.ngb);
        this.ngb.setVisibility(8);
        this.nge = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.a3_, this, false);
        this.ngf = (TextView) this.nge.findViewById(R.id.c4d);
        this.ngg = (TextView) this.nge.findViewById(R.id.c4e);
        addView(this.nge);
        this.nge.setVisibility(8);
        this.ngh = AnimationUtils.loadAnimation(context, R.anim.da);
        this.ngi = AnimationUtils.loadAnimation(context, R.anim.di);
        AppMethodBeat.o(111807);
    }

    public void setText(List<String> list) {
        AppMethodBeat.i(111808);
        this.nga.clear();
        this.neF.stopTimer();
        if (list == null || list.size() == 0 || list.size() % 2 != 0) {
            this.ngb.setVisibility(8);
            this.nge.setVisibility(8);
            AppMethodBeat.o(111808);
            return;
        }
        this.nga.addAll(list);
        this.lfO = 0;
        this.ngc.setText(j.b(getContext(), (CharSequence) this.nga.get(0), this.ngc.getTextSize()));
        this.ngd.setText((CharSequence) this.nga.get(1));
        this.ngb.setVisibility(0);
        this.nge.setVisibility(8);
        if (this.nga.size() / 2 == 1) {
            AppMethodBeat.o(111808);
            return;
        }
        this.neF.ae(5000, 5000);
        AppMethodBeat.o(111808);
    }

    /* Access modifiers changed, original: protected */
    public void onDetachedFromWindow() {
        AppMethodBeat.i(111809);
        super.onDetachedFromWindow();
        this.neF.stopTimer();
        AppMethodBeat.o(111809);
    }

    static /* synthetic */ void a(GameDetailAutoScrollView gameDetailAutoScrollView) {
        AppMethodBeat.i(111810);
        if (gameDetailAutoScrollView.lfO < (gameDetailAutoScrollView.nga.size() / 2) - 1) {
            gameDetailAutoScrollView.lfO++;
        } else {
            gameDetailAutoScrollView.lfO = 0;
        }
        String str = (String) gameDetailAutoScrollView.nga.get((gameDetailAutoScrollView.lfO * 2) + 1);
        gameDetailAutoScrollView.ngf.setText(j.b(gameDetailAutoScrollView.getContext(), (String) gameDetailAutoScrollView.nga.get(gameDetailAutoScrollView.lfO * 2), gameDetailAutoScrollView.ngf.getTextSize()));
        gameDetailAutoScrollView.ngg.setText(str);
        gameDetailAutoScrollView.ngb.startAnimation(gameDetailAutoScrollView.ngi);
        gameDetailAutoScrollView.ngb.setVisibility(8);
        gameDetailAutoScrollView.nge.startAnimation(gameDetailAutoScrollView.ngh);
        gameDetailAutoScrollView.nge.setVisibility(0);
        ViewGroup viewGroup = gameDetailAutoScrollView.ngb;
        gameDetailAutoScrollView.ngb = gameDetailAutoScrollView.nge;
        gameDetailAutoScrollView.nge = viewGroup;
        TextView textView = gameDetailAutoScrollView.ngc;
        gameDetailAutoScrollView.ngc = gameDetailAutoScrollView.ngf;
        gameDetailAutoScrollView.ngf = textView;
        textView = gameDetailAutoScrollView.ngd;
        gameDetailAutoScrollView.ngd = gameDetailAutoScrollView.ngg;
        gameDetailAutoScrollView.ngg = textView;
        AppMethodBeat.o(111810);
    }
}
