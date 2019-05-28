package com.tencent.p177mm.plugin.story.model;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.p057v4.app.Fragment;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.MMFragment;
import com.tencent.p177mm.plugin.luckymoney.particles.C28431d;
import com.tencent.p177mm.plugin.luckymoney.particles.C34448b;
import com.tencent.p177mm.plugin.luckymoney.particles.C34449c;
import com.tencent.p177mm.plugin.luckymoney.particles.p1280a.C28430b;
import com.tencent.p177mm.plugin.story.api.AbsStoryGallery;
import com.tencent.p177mm.plugin.story.api.AbsStoryMuteView;
import com.tencent.p177mm.plugin.story.api.C29268i;
import com.tencent.p177mm.plugin.story.api.C46269m;
import com.tencent.p177mm.plugin.story.api.C46269m.C29273a;
import com.tencent.p177mm.plugin.story.p536ui.album.StoryAlbumUI;
import com.tencent.p177mm.plugin.story.p536ui.view.C46288e;
import com.tencent.p177mm.plugin.story.p536ui.view.StoryMuteView;
import com.tencent.p177mm.plugin.story.p536ui.view.gallery.C35251l;
import com.tencent.p177mm.plugin.story.proxy.C4134b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.storage.C7574bs;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import p000a.C0220l;
import p000a.C44941v;
import p000a.p001a.C7987l;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C41381u.C31596c;
import p000a.p051k.C31820v;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u000bH\u0016J\b\u0010\u001a\u001a\u00020\u001bH\u0002J$\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0006H\u0016J\u0010\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0012H\u0016J\u0010\u0010&\u001a\u00020'2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u0014\u0010(\u001a\u0004\u0018\u00010)2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u001c\u0010*\u001a\u00020+2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010,\u001a\u0004\u0018\u00010-H\u0016J\b\u0010.\u001a\u00020\u0012H\u0002J\b\u0010/\u001a\u00020\u0016H\u0002J\u0010\u00100\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u000bH\u0016J\u0010\u00101\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u000bH\u0016J\u0010\u00102\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u000bH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\bX\u0004¢\u0006\u0002\n\u0000R*\u0010\t\u001a\u001e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nj\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f`\rX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000fj\b\u0012\u0004\u0012\u00020\f`\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000¨\u00063"}, dWq = {"Lcom/tencent/mm/plugin/story/model/StoryUIFactory;", "Lcom/tencent/mm/plugin/story/api/IStoryUIFactory;", "()V", "CONFETTI_WIDTH_DP", "", "TAG", "", "VIVO_COMPATIBLE_LIST", "", "confettiManagers", "Ljava/util/HashMap;", "Landroid/view/View;", "Lcom/tencent/mm/plugin/luckymoney/particles/ConfettiManager;", "Lkotlin/collections/HashMap;", "mRunningConfetti", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "printLog", "", "unreadConfettiGenerator", "Lcom/tencent/mm/plugin/luckymoney/particles/ConfettiGenerator;", "bindUnreadBubbleConfetti", "", "parentView", "Landroid/view/ViewGroup;", "anchor", "genCompatibleBubble", "Landroid/graphics/Bitmap;", "getStoryGallery", "Lcom/tencent/mm/plugin/story/api/AbsStoryGallery;", "context", "Landroid/content/Context;", "type", "Lcom/tencent/mm/plugin/story/api/IStoryUIFactory$GalleryType;", "chatRoom", "getStoryHintDrawable", "Landroid/graphics/drawable/Drawable;", "highLight", "getStoryHintProxy", "Lcom/tencent/mm/plugin/story/api/IStoryHintProxy;", "getStoryMuteView", "Lcom/tencent/mm/plugin/story/api/AbsStoryMuteView;", "instantiateAlbumFragment", "Lcom/tencent/mm/ui/MMFragment;", "bundle", "Landroid/os/Bundle;", "isInCompatibleList", "lazyInit", "startUnreadBubbleConfetti", "stopUnreadBubbleConfetti", "unbindUnreadBubbleConfetti", "plugin-story_release"})
/* renamed from: com.tencent.mm.plugin.story.model.r */
public final class C43648r implements C46269m {
    private static final String TAG = TAG;
    private static C34448b rTM;
    private static HashMap<View, C34449c> rTN = new HashMap();
    private static ArrayList<C34449c> rTO = new ArrayList();
    private static int rTP;
    private static boolean rTQ = true;
    private static final List<String> rTR = C7987l.listOf("y83a", "v1732a", " y83", "v1732t");
    public static final C43648r rTS = new C43648r();

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "Lcom/tencent/mm/plugin/story/ui/view/CommentTipSmallConfetti;", "it", "Ljava/util/Random;", "kotlin.jvm.PlatformType", "generateConfetti"})
    /* renamed from: com.tencent.mm.plugin.story.model.r$a */
    static final class C36820a implements C34448b {
        final /* synthetic */ C31596c rTT;

        C36820a(C31596c c31596c) {
            this.rTT = c31596c;
        }

        /* renamed from: b */
        public final /* synthetic */ C28430b mo24309b(Random random) {
            AppMethodBeat.m2504i(109154);
            Bitmap bitmap = (Bitmap) this.rTT.AVE;
            C25052j.m39375o(bitmap, "scaled");
            C28430b c46288e = new C46288e(bitmap);
            AppMethodBeat.m2505o(109154);
            return c46288e;
        }
    }

    static {
        AppMethodBeat.m2504i(109164);
        AppMethodBeat.m2505o(109164);
    }

    private C43648r() {
    }

    /* renamed from: eW */
    public final C29268i mo69259eW(Context context) {
        AppMethodBeat.m2504i(109155);
        C25052j.m39376p(context, "context");
        C29268i c4134b = new C4134b(context);
        AppMethodBeat.m2505o(109155);
        return c4134b;
    }

    /* renamed from: a */
    public final AbsStoryGallery mo69256a(Context context, C29273a c29273a, String str) {
        AppMethodBeat.m2504i(109156);
        C25052j.m39376p(context, "context");
        C25052j.m39376p(c29273a, "type");
        C35251l c35251l = new C35251l(context, c29273a);
        c35251l.setChatRoom(str);
        AbsStoryGallery absStoryGallery = c35251l;
        AppMethodBeat.m2505o(109156);
        return absStoryGallery;
    }

    /* renamed from: eV */
    public final AbsStoryMuteView mo69258eV(Context context) {
        AppMethodBeat.m2504i(109157);
        AbsStoryMuteView absStoryMuteView = null;
        if (context != null) {
            absStoryMuteView = new StoryMuteView(context);
        }
        AppMethodBeat.m2505o(109157);
        return absStoryMuteView;
    }

    public final MMFragment instantiateAlbumFragment(Context context, Bundle bundle) {
        AppMethodBeat.m2504i(109158);
        Fragment instantiate = Fragment.instantiate(context, StoryAlbumUI.class.getName(), bundle);
        if (instantiate == null) {
            C44941v c44941v = new C44941v("null cannot be cast to non-null type com.tencent.mm.ui.MMFragment");
            AppMethodBeat.m2505o(109158);
            throw c44941v;
        }
        MMFragment mMFragment = (MMFragment) instantiate;
        AppMethodBeat.m2505o(109158);
        return mMFragment;
    }

    /* renamed from: ls */
    public final Drawable mo69264ls(boolean z) {
        int i;
        AppMethodBeat.m2504i(109159);
        if (z) {
            i = C1318a.chatting_avatar_story_hint;
        } else {
            i = C1318a.chatting_avatar_story_hint_white;
        }
        Context context = C4996ah.getContext();
        C25052j.m39375o(context, "MMApplicationContext.getContext()");
        Drawable drawable = context.getResources().getDrawable(i);
        int fromDPToPix = C1338a.fromDPToPix(C4996ah.getContext(), 8);
        drawable.setBounds(0, 0, fromDPToPix, fromDPToPix);
        C25052j.m39375o(drawable, "hintDrawable");
        AppMethodBeat.m2505o(109159);
        return drawable;
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x0067 A:{SYNTHETIC} */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x009c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: d */
    public final void mo69257d(ViewGroup viewGroup, View view) {
        int i;
        AppMethodBeat.m2504i(109160);
        C25052j.m39376p(view, "anchor");
        if (rTM == null) {
            boolean z;
            Object decodeResource;
            rTP = C1338a.fromDPToPix(C4996ah.getContext(), 8);
            C31596c c31596c = new C31596c();
            if (rTQ) {
                C4990ab.m7416i(TAG, "isInCompatibleList " + Build.BRAND + "  config " + C7574bs.dut() + ' ');
                rTQ = false;
            }
            Collection arrayList = new ArrayList();
            for (Object next : rTR) {
                String str = (String) next;
                String str2 = Build.MODEL;
                C25052j.m39375o(str2, "Build.MODEL");
                if (!C31820v.m51526a((CharSequence) str2, (CharSequence) str, true)) {
                    str2 = Build.DEVICE;
                    C25052j.m39375o(str2, "Build.DEVICE");
                    if (!C31820v.m51526a((CharSequence) str2, (CharSequence) str, true)) {
                        z = false;
                        if (!z) {
                            arrayList.add(next);
                        }
                    }
                }
                z = true;
                if (!z) {
                }
            }
            List list = (List) arrayList;
            if (C25052j.m39373j(Build.BRAND, "vivo") && !list.isEmpty() && VERSION.SDK_INT == 27) {
                z = true;
            } else {
                z = false;
            }
            Context context;
            if (z) {
                context = C4996ah.getContext();
                C25052j.m39375o(context, "MMApplicationContext.getContext()");
                decodeResource = BitmapFactory.decodeResource(context.getResources(), C25738R.drawable.ap4);
                C25052j.m39375o(decodeResource, "BitmapFactory.decodeReso…ble.story_comment_bubble)");
            } else {
                context = C4996ah.getContext();
                C25052j.m39375o(context, "MMApplicationContext.getContext()");
                Bitmap decodeResource2 = BitmapFactory.decodeResource(context.getResources(), C25738R.drawable.ap4);
                i = rTP;
                decodeResource = Bitmap.createScaledBitmap(decodeResource2, i, i, true);
            }
            c31596c.AVE = decodeResource;
            rTM = new C36820a(c31596c);
        }
        if (!rTN.containsKey(view)) {
            int left = (view.getLeft() + (view.getWidth() / 2)) - (rTP / 2);
            i = view.getTop();
            C4990ab.m7410d(TAG, "bindUnreadBubbleConfetti containerMiddleX=" + left + " containerMiddleY=" + i);
            C34449c bLK = new C34449c(C4996ah.getContext(), rTM, new C28431d(left, i), viewGroup).bLG().mo54984aF(8.0f).mo54982R(0.0f, 15.0f).mo54983S(-60.0f, 10.0f).bLK();
            Map map = rTN;
            C25052j.m39375o(bLK, "manager");
            map.put(view, bLK);
        }
        AppMethodBeat.m2505o(109160);
    }

    /* renamed from: ee */
    public final void mo69260ee(View view) {
        AppMethodBeat.m2504i(109161);
        C25052j.m39376p(view, "anchor");
        if (rTN.containsKey(view)) {
            rTN.remove(view);
        }
        AppMethodBeat.m2505o(109161);
    }

    /* renamed from: ef */
    public final void mo69261ef(View view) {
        AppMethodBeat.m2504i(109162);
        C25052j.m39376p(view, "anchor");
        C4990ab.m7410d(TAG, "startUnreadBubbleConfetti mRunningConfetti=" + rTO);
        C34449c c34449c = (C34449c) rTN.get(view);
        if (c34449c != null) {
            if (!rTO.contains(c34449c)) {
                C4990ab.m7410d(TAG, "startUnreadBubbleConfetti");
                c34449c.bLL();
                rTO.add(c34449c);
            }
            AppMethodBeat.m2505o(109162);
            return;
        }
        AppMethodBeat.m2505o(109162);
    }

    /* renamed from: eg */
    public final void mo69262eg(View view) {
        AppMethodBeat.m2504i(109163);
        C25052j.m39376p(view, "anchor");
        C4990ab.m7410d(TAG, "stopUnreadBubbleConfetti mRunningConfetti=" + rTO);
        C34449c c34449c = (C34449c) rTN.get(view);
        if (c34449c != null) {
            if (rTO.contains(c34449c)) {
                C4990ab.m7408b(TAG, "stopUnreadBubbleConfetti", new Object[0]);
                c34449c.bLM();
                rTO.remove(c34449c);
            }
            AppMethodBeat.m2505o(109163);
            return;
        }
        AppMethodBeat.m2505o(109163);
    }
}
