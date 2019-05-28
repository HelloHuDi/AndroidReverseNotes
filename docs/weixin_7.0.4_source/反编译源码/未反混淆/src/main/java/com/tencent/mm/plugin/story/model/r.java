package com.tencent.mm.plugin.story.model;

import a.f.b.j;
import a.f.b.u;
import a.l;
import a.v;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.luckymoney.particles.b;
import com.tencent.mm.plugin.luckymoney.particles.c;
import com.tencent.mm.plugin.luckymoney.particles.d;
import com.tencent.mm.plugin.story.api.AbsStoryGallery;
import com.tencent.mm.plugin.story.api.AbsStoryMuteView;
import com.tencent.mm.plugin.story.api.i;
import com.tencent.mm.plugin.story.api.m;
import com.tencent.mm.plugin.story.ui.album.StoryAlbumUI;
import com.tencent.mm.plugin.story.ui.view.StoryMuteView;
import com.tencent.mm.plugin.story.ui.view.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.storage.bs;
import com.tencent.mm.ui.MMFragment;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

@l(dWo = {1, 1, 13}, dWp = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u000bH\u0016J\b\u0010\u001a\u001a\u00020\u001bH\u0002J$\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0006H\u0016J\u0010\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0012H\u0016J\u0010\u0010&\u001a\u00020'2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u0014\u0010(\u001a\u0004\u0018\u00010)2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u001c\u0010*\u001a\u00020+2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010,\u001a\u0004\u0018\u00010-H\u0016J\b\u0010.\u001a\u00020\u0012H\u0002J\b\u0010/\u001a\u00020\u0016H\u0002J\u0010\u00100\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u000bH\u0016J\u0010\u00101\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u000bH\u0016J\u0010\u00102\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u000bH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\bX\u0004¢\u0006\u0002\n\u0000R*\u0010\t\u001a\u001e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nj\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f`\rX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000fj\b\u0012\u0004\u0012\u00020\f`\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000¨\u00063"}, dWq = {"Lcom/tencent/mm/plugin/story/model/StoryUIFactory;", "Lcom/tencent/mm/plugin/story/api/IStoryUIFactory;", "()V", "CONFETTI_WIDTH_DP", "", "TAG", "", "VIVO_COMPATIBLE_LIST", "", "confettiManagers", "Ljava/util/HashMap;", "Landroid/view/View;", "Lcom/tencent/mm/plugin/luckymoney/particles/ConfettiManager;", "Lkotlin/collections/HashMap;", "mRunningConfetti", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "printLog", "", "unreadConfettiGenerator", "Lcom/tencent/mm/plugin/luckymoney/particles/ConfettiGenerator;", "bindUnreadBubbleConfetti", "", "parentView", "Landroid/view/ViewGroup;", "anchor", "genCompatibleBubble", "Landroid/graphics/Bitmap;", "getStoryGallery", "Lcom/tencent/mm/plugin/story/api/AbsStoryGallery;", "context", "Landroid/content/Context;", "type", "Lcom/tencent/mm/plugin/story/api/IStoryUIFactory$GalleryType;", "chatRoom", "getStoryHintDrawable", "Landroid/graphics/drawable/Drawable;", "highLight", "getStoryHintProxy", "Lcom/tencent/mm/plugin/story/api/IStoryHintProxy;", "getStoryMuteView", "Lcom/tencent/mm/plugin/story/api/AbsStoryMuteView;", "instantiateAlbumFragment", "Lcom/tencent/mm/ui/MMFragment;", "bundle", "Landroid/os/Bundle;", "isInCompatibleList", "lazyInit", "startUnreadBubbleConfetti", "stopUnreadBubbleConfetti", "unbindUnreadBubbleConfetti", "plugin-story_release"})
public final class r implements m {
    private static final String TAG = TAG;
    private static b rTM;
    private static HashMap<View, c> rTN = new HashMap();
    private static ArrayList<c> rTO = new ArrayList();
    private static int rTP;
    private static boolean rTQ = true;
    private static final List<String> rTR = a.a.l.listOf("y83a", "v1732a", " y83", "v1732t");
    public static final r rTS = new r();

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "Lcom/tencent/mm/plugin/story/ui/view/CommentTipSmallConfetti;", "it", "Ljava/util/Random;", "kotlin.jvm.PlatformType", "generateConfetti"})
    static final class a implements b {
        final /* synthetic */ u.c rTT;

        a(u.c cVar) {
            this.rTT = cVar;
        }

        public final /* synthetic */ com.tencent.mm.plugin.luckymoney.particles.a.b b(Random random) {
            AppMethodBeat.i(109154);
            Bitmap bitmap = (Bitmap) this.rTT.AVE;
            j.o(bitmap, "scaled");
            com.tencent.mm.plugin.luckymoney.particles.a.b eVar = new e(bitmap);
            AppMethodBeat.o(109154);
            return eVar;
        }
    }

    static {
        AppMethodBeat.i(109164);
        AppMethodBeat.o(109164);
    }

    private r() {
    }

    public final i eW(Context context) {
        AppMethodBeat.i(109155);
        j.p(context, "context");
        i bVar = new com.tencent.mm.plugin.story.proxy.b(context);
        AppMethodBeat.o(109155);
        return bVar;
    }

    public final AbsStoryGallery a(Context context, com.tencent.mm.plugin.story.api.m.a aVar, String str) {
        AppMethodBeat.i(109156);
        j.p(context, "context");
        j.p(aVar, "type");
        com.tencent.mm.plugin.story.ui.view.gallery.l lVar = new com.tencent.mm.plugin.story.ui.view.gallery.l(context, aVar);
        lVar.setChatRoom(str);
        AbsStoryGallery absStoryGallery = lVar;
        AppMethodBeat.o(109156);
        return absStoryGallery;
    }

    public final AbsStoryMuteView eV(Context context) {
        AppMethodBeat.i(109157);
        AbsStoryMuteView absStoryMuteView = null;
        if (context != null) {
            absStoryMuteView = new StoryMuteView(context);
        }
        AppMethodBeat.o(109157);
        return absStoryMuteView;
    }

    public final MMFragment instantiateAlbumFragment(Context context, Bundle bundle) {
        AppMethodBeat.i(109158);
        Fragment instantiate = Fragment.instantiate(context, StoryAlbumUI.class.getName(), bundle);
        if (instantiate == null) {
            v vVar = new v("null cannot be cast to non-null type com.tencent.mm.ui.MMFragment");
            AppMethodBeat.o(109158);
            throw vVar;
        }
        MMFragment mMFragment = (MMFragment) instantiate;
        AppMethodBeat.o(109158);
        return mMFragment;
    }

    public final Drawable ls(boolean z) {
        int i;
        AppMethodBeat.i(109159);
        if (z) {
            i = R.raw.chatting_avatar_story_hint;
        } else {
            i = R.raw.chatting_avatar_story_hint_white;
        }
        Context context = ah.getContext();
        j.o(context, "MMApplicationContext.getContext()");
        Drawable drawable = context.getResources().getDrawable(i);
        int fromDPToPix = com.tencent.mm.bz.a.fromDPToPix(ah.getContext(), 8);
        drawable.setBounds(0, 0, fromDPToPix, fromDPToPix);
        j.o(drawable, "hintDrawable");
        AppMethodBeat.o(109159);
        return drawable;
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x0067 A:{SYNTHETIC} */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x009c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void d(ViewGroup viewGroup, View view) {
        int i;
        AppMethodBeat.i(109160);
        j.p(view, "anchor");
        if (rTM == null) {
            boolean z;
            Object decodeResource;
            rTP = com.tencent.mm.bz.a.fromDPToPix(ah.getContext(), 8);
            u.c cVar = new u.c();
            if (rTQ) {
                ab.i(TAG, "isInCompatibleList " + Build.BRAND + "  config " + bs.dut() + ' ');
                rTQ = false;
            }
            Collection arrayList = new ArrayList();
            for (Object next : rTR) {
                String str = (String) next;
                String str2 = Build.MODEL;
                j.o(str2, "Build.MODEL");
                if (!a.k.v.a((CharSequence) str2, (CharSequence) str, true)) {
                    str2 = Build.DEVICE;
                    j.o(str2, "Build.DEVICE");
                    if (!a.k.v.a((CharSequence) str2, (CharSequence) str, true)) {
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
            if (j.j(Build.BRAND, "vivo") && !list.isEmpty() && VERSION.SDK_INT == 27) {
                z = true;
            } else {
                z = false;
            }
            Context context;
            if (z) {
                context = ah.getContext();
                j.o(context, "MMApplicationContext.getContext()");
                decodeResource = BitmapFactory.decodeResource(context.getResources(), R.drawable.ap4);
                j.o(decodeResource, "BitmapFactory.decodeReso…ble.story_comment_bubble)");
            } else {
                context = ah.getContext();
                j.o(context, "MMApplicationContext.getContext()");
                Bitmap decodeResource2 = BitmapFactory.decodeResource(context.getResources(), R.drawable.ap4);
                i = rTP;
                decodeResource = Bitmap.createScaledBitmap(decodeResource2, i, i, true);
            }
            cVar.AVE = decodeResource;
            rTM = new a(cVar);
        }
        if (!rTN.containsKey(view)) {
            int left = (view.getLeft() + (view.getWidth() / 2)) - (rTP / 2);
            i = view.getTop();
            ab.d(TAG, "bindUnreadBubbleConfetti containerMiddleX=" + left + " containerMiddleY=" + i);
            c bLK = new c(ah.getContext(), rTM, new d(left, i), viewGroup).bLG().aF(8.0f).R(0.0f, 15.0f).S(-60.0f, 10.0f).bLK();
            Map map = rTN;
            j.o(bLK, "manager");
            map.put(view, bLK);
        }
        AppMethodBeat.o(109160);
    }

    public final void ee(View view) {
        AppMethodBeat.i(109161);
        j.p(view, "anchor");
        if (rTN.containsKey(view)) {
            rTN.remove(view);
        }
        AppMethodBeat.o(109161);
    }

    public final void ef(View view) {
        AppMethodBeat.i(109162);
        j.p(view, "anchor");
        ab.d(TAG, "startUnreadBubbleConfetti mRunningConfetti=" + rTO);
        c cVar = (c) rTN.get(view);
        if (cVar != null) {
            if (!rTO.contains(cVar)) {
                ab.d(TAG, "startUnreadBubbleConfetti");
                cVar.bLL();
                rTO.add(cVar);
            }
            AppMethodBeat.o(109162);
            return;
        }
        AppMethodBeat.o(109162);
    }

    public final void eg(View view) {
        AppMethodBeat.i(109163);
        j.p(view, "anchor");
        ab.d(TAG, "stopUnreadBubbleConfetti mRunningConfetti=" + rTO);
        c cVar = (c) rTN.get(view);
        if (cVar != null) {
            if (rTO.contains(cVar)) {
                ab.b(TAG, "stopUnreadBubbleConfetti", new Object[0]);
                cVar.bLM();
                rTO.remove(cVar);
            }
            AppMethodBeat.o(109163);
            return;
        }
        AppMethodBeat.o(109163);
    }
}
