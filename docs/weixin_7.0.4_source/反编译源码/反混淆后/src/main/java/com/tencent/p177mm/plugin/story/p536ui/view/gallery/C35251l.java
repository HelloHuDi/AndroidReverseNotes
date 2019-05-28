package com.tencent.p177mm.plugin.story.p536ui.view.gallery;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.p069v7.widget.C17491an;
import android.support.p069v7.widget.RecyclerView;
import android.support.p069v7.widget.RecyclerView.C17480i;
import android.support.p069v7.widget.RecyclerView.C41523a;
import android.text.SpannableString;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs.CastExtraArgs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.kernel.C1706e;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.loader.C18532d;
import com.tencent.p177mm.loader.C24669a;
import com.tencent.p177mm.loader.C37881e;
import com.tencent.p177mm.model.C1839cb;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p230g.p232b.p233a.C9502ar;
import com.tencent.p177mm.p230g.p232b.p233a.C9504au;
import com.tencent.p177mm.p612ui.C5222ae;
import com.tencent.p177mm.p612ui.C5225ah;
import com.tencent.p177mm.p612ui.C5230ak;
import com.tencent.p177mm.p612ui.base.C23639t;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.p612ui.widget.C5664a;
import com.tencent.p177mm.p612ui.widget.listview.PullDownListView;
import com.tencent.p177mm.p612ui.widget.p633a.C5663e.C5659a;
import com.tencent.p177mm.p612ui.widget.p633a.C5663e.C5662c;
import com.tencent.p177mm.p823ab.C8902b;
import com.tencent.p177mm.plugin.story.api.AbsStoryGallery;
import com.tencent.p177mm.plugin.story.api.C22174j;
import com.tencent.p177mm.plugin.story.api.C29269k.C29271a;
import com.tencent.p177mm.plugin.story.api.C35171g;
import com.tencent.p177mm.plugin.story.api.C39864o;
import com.tencent.p177mm.plugin.story.api.C46269m.C29273a;
import com.tencent.p177mm.plugin.story.model.C13774d;
import com.tencent.p177mm.plugin.story.model.C29304c;
import com.tencent.p177mm.plugin.story.model.C43641i;
import com.tencent.p177mm.plugin.story.model.C43641i.C43642a;
import com.tencent.p177mm.plugin.story.model.C43641i.C43642a.C43643b;
import com.tencent.p177mm.plugin.story.model.C43644j;
import com.tencent.p177mm.plugin.story.model.C43644j.C4133a;
import com.tencent.p177mm.plugin.story.model.p1035b.C46279b;
import com.tencent.p177mm.plugin.story.model.p1304c.C24833d;
import com.tencent.p177mm.plugin.story.model.p533d.C35201i;
import com.tencent.p177mm.plugin.story.model.p533d.C43638e;
import com.tencent.p177mm.plugin.story.model.p533d.C43640g;
import com.tencent.p177mm.plugin.story.model.p534f.C31431d;
import com.tencent.p177mm.plugin.story.p1032c.p1033a.C29274a;
import com.tencent.p177mm.plugin.story.p1032c.p1033a.C29274a.C13738a;
import com.tencent.p177mm.plugin.story.p530f.C22210l;
import com.tencent.p177mm.plugin.story.p530f.C39875f;
import com.tencent.p177mm.plugin.story.p530f.C39876h;
import com.tencent.p177mm.plugin.story.p530f.C43632e;
import com.tencent.p177mm.plugin.story.p531g.C22212h;
import com.tencent.p177mm.plugin.story.p531g.C35180c;
import com.tencent.p177mm.plugin.story.p531g.C4116b;
import com.tencent.p177mm.plugin.story.p532h.C39879j;
import com.tencent.p177mm.plugin.story.p532h.C46275k;
import com.tencent.p177mm.plugin.story.p536ui.album.StoryFavAlbumUI;
import com.tencent.p177mm.plugin.story.p536ui.p1037a.C13814d;
import com.tencent.p177mm.plugin.story.p536ui.p1037a.C29324g;
import com.tencent.p177mm.plugin.story.p536ui.p1305b.C22261a;
import com.tencent.p177mm.plugin.story.p536ui.p1305b.C22262b;
import com.tencent.p177mm.plugin.story.p536ui.view.StoryCommentView;
import com.tencent.p177mm.plugin.story.p536ui.view.gallery.C4172f.C4173a;
import com.tencent.p177mm.plugin.story.p536ui.view.gallery.GalleryRecyclerView.C13879b;
import com.tencent.p177mm.plugin.story.proxy.C4140c;
import com.tencent.p177mm.plugin.story.proxy.C4140c.C4141a;
import com.tencent.p177mm.protocal.protobuf.cee;
import com.tencent.p177mm.protocal.protobuf.cek;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C44222az;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import java.util.ArrayList;
import java.util.List;
import p000a.C0220l;
import p000a.C37091y;
import p000a.C44941v;
import p000a.p001a.C7987l;
import p000a.p005f.p006a.C17126b;
import p000a.p005f.p006a.C31214a;
import p000a.p005f.p006a.C31591m;
import p000a.p005f.p006a.C36933q;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C25053k;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u000b*\u0002(P\u0018\u0000 ²\u00012\u00020\u0001:\u0004²\u0001³\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010o\u001a\u00020pH\u0002J\b\u0010q\u001a\u00020pH\u0002J\u0012\u0010r\u001a\u00020p2\b\u0010s\u001a\u0004\u0018\u00010tH\u0016J\u0010\u0010u\u001a\u00020\t2\u0006\u0010v\u001a\u00020\u0007H\u0016J\u001a\u0010w\u001a\u00020p2\b\b\u0002\u0010x\u001a\u00020\u00072\b\b\u0002\u0010y\u001a\u00020\u0007J\b\u0010z\u001a\u00020pH\u0016J\b\u0010{\u001a\u00020\u0007H\u0002J\u0010\u0010|\u001a\u00020\t2\u0006\u0010}\u001a\u00020~H\u0016J\b\u0010\u001a\u00020pH\u0002J\t\u0010\u0001\u001a\u00020pH\u0002J\t\u0010\u0001\u001a\u00020\tH\u0002J\t\u0010\u0001\u001a\u00020\tH\u0016J\u0012\u0010\u0001\u001a\u00020p2\u0007\u0010\u0001\u001a\u00020\u0007H\u0016J\t\u0010\u0001\u001a\u00020pH\u0002J\t\u0010\u0001\u001a\u00020pH\u0016J\u001d\u0010\u0001\u001a\u00020p2\u0007\u0010\u0001\u001a\u00020\u00072\t\u0010\u0001\u001a\u0004\u0018\u00010GH\u0002J\u0012\u0010\u0001\u001a\u00020p2\u0007\u0010\u0001\u001a\u00020\u0007H\u0016J\u0012\u0010\u0001\u001a\u00020p2\u0007\u0010\u0001\u001a\u00020\u0007H\u0016J\t\u0010\u0001\u001a\u00020pH\u0016J\t\u0010\u0001\u001a\u00020pH\u0016J\t\u0010\u0001\u001a\u00020pH\u0016J\t\u0010\u0001\u001a\u00020pH\u0016J(\u0010\u0001\u001a\u00020p2\u0007\u0010\u0001\u001a\u00020\u00072\t\u0010\u0001\u001a\u0004\u0018\u0001052\t\u0010\u0001\u001a\u0004\u0018\u00010LH\u0002J\t\u0010\u0001\u001a\u00020pH\u0002J\t\u0010\u0001\u001a\u00020pH\u0002J\t\u0010\u0001\u001a\u00020pH\u0016J\t\u0010\u0001\u001a\u00020pH\u0016J\u0012\u0010\u0001\u001a\u00020p2\u0007\u0010\u0001\u001a\u00020\tH\u0016J#\u0010\u0001\u001a\u00020p2\u0006\u0010?\u001a\u00020\t2\u0007\u0010\u0001\u001a\u00020\t2\u0007\u0010\u0001\u001a\u00020\tH\u0016J\u0010\u0010\u0001\u001a\u00020p2\u0007\u0010\u0001\u001a\u00020\u0007J\t\u0010\u0001\u001a\u00020pH\u0002J\u0013\u0010\u0001\u001a\u00020p2\b\u0010 \u0001\u001a\u00030¡\u0001H\u0002J\u0007\u0010¢\u0001\u001a\u00020pJ\u0010\u0010£\u0001\u001a\u00020p2\u0007\u0010¤\u0001\u001a\u00020\tJ\u0012\u0010¥\u0001\u001a\u00020p2\u0007\u0010\u0001\u001a\u00020\u0007H\u0016J\u0012\u0010¦\u0001\u001a\u00020p2\u0007\u0010\u0001\u001a\u00020\u0007H\u0016J\u0015\u0010§\u0001\u001a\u00020p2\n\u0010¨\u0001\u001a\u0005\u0018\u00010©\u0001H\u0002J\u0015\u0010ª\u0001\u001a\u00020p2\n\u0010¨\u0001\u001a\u0005\u0018\u00010©\u0001H\u0016J\u0007\u0010«\u0001\u001a\u00020pJ\u0010\u0010¬\u0001\u001a\u00020p2\u0007\u0010­\u0001\u001a\u00020/J\u0014\u0010®\u0001\u001a\u00020p2\t\u0010­\u0001\u001a\u0004\u0018\u00010\u000fH\u0016J\t\u0010¯\u0001\u001a\u00020pH\u0016J\u0012\u0010°\u0001\u001a\u00020p2\u0007\u0010±\u0001\u001a\u00020\tH\u0002R\u000e\u0010\u000b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R(\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\t0\u0019X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001d\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u000e\u0010\"\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0010\u0010'\u001a\u00020(X\u0004¢\u0006\u0004\n\u0002\u0010)R>\u0010*\u001a2\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020,0+j\b\u0012\u0004\u0012\u00020,`-0+j\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020,0+j\b\u0012\u0004\u0012\u00020,`-`-X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u0004\u0018\u00010/X\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u000201X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u0010\u00104\u001a\u0004\u0018\u000105X\u000e¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u000208X\u0004¢\u0006\u0002\n\u0000R\u0010\u00109\u001a\u0004\u0018\u00010:X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010;\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010\u001f\"\u0004\b<\u0010!R\u001a\u0010=\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010\u001f\"\u0004\b>\u0010!R\u000e\u0010?\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010@\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010\u001f\"\u0004\bA\u0010!R\u000e\u0010B\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010E\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010F\u001a\u00020GX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010H\u001a\u0004\u0018\u00010IX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010J\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010K\u001a\u0004\u0018\u00010LX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010M\u001a\u00020NX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010O\u001a\u00020PX\u0004¢\u0006\u0004\n\u0002\u0010QR\u0010\u0010R\u001a\u0004\u0018\u00010SX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010T\u001a\u00020UX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010V\u001a\u0004\u0018\u00010GX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010W\u001a\u00020XX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010Y\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010Z\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010[\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\\\u0010\u0015\"\u0004\b]\u0010\u0017R\u0010\u0010^\u001a\u0004\u0018\u00010_X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010`\u001a\u00020aX\u0004¢\u0006\u0002\n\u0000R\u0012\u0010b\u001a\u00060cR\u00020aX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010d\u001a\u00020eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010f\u001a\u00020gX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010h\u001a\u00020iX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010j\u001a\u0004\u0018\u00010kX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010l\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bm\u0010\u001f\"\u0004\bn\u0010!¨\u0006´\u0001"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryView;", "Lcom/tencent/mm/plugin/story/api/AbsStoryGallery;", "context", "Landroid/content/Context;", "galleryType", "Lcom/tencent/mm/plugin/story/api/IStoryUIFactory$GalleryType;", "expectPos", "", "needAction", "", "(Landroid/content/Context;Lcom/tencent/mm/plugin/story/api/IStoryUIFactory$GalleryType;IZ)V", "activePanel", "addReadNumRunnable", "Ljava/lang/Runnable;", "browseUIListener", "Lcom/tencent/mm/plugin/story/api/IStoryBrowseUIListener;", "canDragScale", "value", "", "chatRoom", "getChatRoom", "()Ljava/lang/String;", "setChatRoom", "(Ljava/lang/String;)V", "clickListener", "Lkotlin/Function0;", "commentScrolling", "currentItemView", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryItemView;", "deleteWhenFirstEmpty", "getDeleteWhenFirstEmpty", "()Z", "setDeleteWhenFirstEmpty", "(Z)V", "dirty", "dragCloseConsumer", "Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryDragCloseConsumer;", "getExpectPos", "()I", "galleryGroupUpdateCallback", "com/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryView$galleryGroupUpdateCallback$1", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryView$galleryGroupUpdateCallback$1;", "galleryGroups", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItem;", "Lkotlin/collections/ArrayList;", "galleryScaleListener", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryView$IOnGalleryScale;", "galleryScrollHelper", "Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryScrollHelper;", "getGalleryType", "()Lcom/tencent/mm/plugin/story/api/IStoryUIFactory$GalleryType;", "hRecyclerView", "Landroid/support/v7/widget/RecyclerView;", "hasDispatchCancel", "holderView", "Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryHolderView;", "horizontalAdapter", "Lcom/tencent/mm/plugin/story/ui/adapter/StoryGalleryAdapter;", "isFirstPost", "setFirstPost", "isForSns", "setForSns", "isMute", "isNeedReset", "setNeedReset", "isSelf", "jumpItemReport", "lastSelectColumn", "mIsActive", "maskView", "Landroid/view/View;", "menuDialog", "Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryDeleteDialog;", "needCancelTouch", "pageIndicator", "Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryHorizontalControlView;", "pageSnapHelper", "Landroid/support/v7/widget/PagerSnapHelper;", "postListener", "com/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryView$postListener$1", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryView$postListener$1;", "presenter", "Lcom/tencent/mm/plugin/story/presenter/IGalleryPresenter;", "pullDownHint", "Landroid/widget/TextView;", "pullDownListView", "scrollUpHintCheck", "Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryScrollUpCheck;", "selectedColumn", "selectedRow", "sessionId", "getSessionId", "setSessionId", "tipDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "vRecyclerView", "Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryRecyclerView;", "verticalAdapter", "Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryRecyclerView$VerticalAdapter;", "verticalControlView", "Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryVerticalControlView;", "verticalPageSnapHelper", "Lcom/tencent/mm/plugin/story/ui/view/gallery/PageScrollHelper;", "verticalScrollOffset", "", "videoViewMgr", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgr;", "videoViewMgrFromPreLoad", "getVideoViewMgrFromPreLoad", "setVideoViewMgrFromPreLoad", "addListeners", "", "addVideoReadNumber", "bindPullDownListView", "wrapperView", "Lcom/tencent/mm/ui/widget/listview/PullDownListView;", "canScrollHorizontally", "direction", "checkDoPreloadBeforeEnterGallery", "verticalIndex", "horizontalIndex", "checkUpdate", "contentScrollType", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "fadeInMaskView", "fadeOutMaskView", "needVerticalControl", "onBackPressed", "onClosing", "offset", "onDeleteStory", "onDestroy", "onItemSelected", "position", "childView", "onListInnerScroll", "onOpening", "onPause", "onPreImageMode", "onPreVideoMode", "onResume", "onRowSelected", "row", "rowView", "horizontalControlView", "onSetFavoriteStory", "onSetPrivacy", "onStart", "onStop", "onSwitchImageMode", "enableReport", "onSwitchVideoMode", "fromPreCache", "remixItem", "mediaLocalId", "removeListeners", "resendItem", "storyVideoItem", "Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "reset", "setCanDragScale", "canScale", "setCurrentHItem", "setCurrentVItem", "setDataInternal", "dataSeed", "", "setDataSeed", "setFilterList", "setGalleryScaleListener", "listener", "setStoryBrowseUIListener", "showPullDownHint", "toggleActiveState", "newActive", "Companion", "IOnGalleryScale", "plugin-story_release"})
/* renamed from: com.tencent.mm.plugin.story.ui.view.gallery.l */
public final class C35251l extends AbsStoryGallery {
    private static final String TAG = TAG;
    public static final C35259a spJ = new C35259a();
    private String cvF;
    private boolean czr;
    private boolean dirty;
    private boolean eif;
    private String gpx;
    private View iVh;
    private final int rZE;
    private boolean rZI;
    private int rZb;
    private C4172f shf;
    private boolean shh;
    private boolean shi;
    private boolean shj;
    private final C31214a<Boolean> skn;
    final C29273a soE;
    private C22319p soY;
    private C13884b soz;
    private final C4175g spA;
    private boolean spB;
    private final C35252g spC;
    private int spD;
    private boolean spE;
    private boolean spF;
    private boolean spG;
    private final C4189m spH;
    private Runnable spI;
    private boolean spd;
    private boolean spe;
    private View spf;
    final TextView spg;
    private StoryGalleryItemView sph;
    private RecyclerView spi;
    private GalleryHorizontalControlView spj;
    private C29324g spk;
    private final C17491an spl;
    private final C4185j spm;
    private int spn;
    private float spo;
    private final GalleryRecyclerView spq;
    private final ArrayList<ArrayList<C43640g>> spr;
    private C39876h sps;
    private boolean spt;
    private C35171g spu;
    private boolean spv;
    private C36821c spw;
    private final GalleryVerticalControlView spx;
    private C29366a spy;
    private final GalleryHolderView spz;
    private final C13879b tBv;
    private C44275p tipDialog;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\n"}, dWq = {"com/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryView$postListener$1", "Lcom/tencent/mm/plugin/story/api/IStoryPostListener;", "onPostEnd", "", "localId", "", "isOk", "", "onPostNotify", "onPostStart", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.gallery.l$m */
    public static final class C4189m implements C22174j {
        final /* synthetic */ C35251l spK;

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
        /* renamed from: com.tencent.mm.plugin.story.ui.view.gallery.l$m$a */
        static final class C4190a implements Runnable {
            final /* synthetic */ int rXD;
            final /* synthetic */ C4189m spS;

            C4190a(C4189m c4189m, int i) {
                this.spS = c4189m;
                this.rXD = i;
            }

            public final void run() {
                AppMethodBeat.m2504i(110813);
                C1706e RP = C1720g.m3536RP();
                C25052j.m39375o(RP, "MMKernel.storage()");
                boolean z = RP.mo5239Ry().getBoolean(C5127a.USERINFO_STORY_POST_FIRST_TO_AUTOPLAY_BOOLEAN_SYNC, true);
                C35259a c35259a = C35251l.spJ;
                C4990ab.m7416i(C35251l.TAG, "onPostStart " + this.rXD + " and ret " + z);
                if (z) {
                    this.spS.spK.setFirstPost(true);
                    this.spS.spK.mo55932K(true, false);
                }
                AppMethodBeat.m2505o(110813);
            }
        }

        C4189m(C35251l c35251l) {
            this.spK = c35251l;
        }

        public final void cwX() {
            AppMethodBeat.m2504i(110814);
            if (this.spK.czr) {
                C39876h l = this.spK.sps;
                if (l != null) {
                    l.czC();
                    AppMethodBeat.m2505o(110814);
                    return;
                }
            }
            AppMethodBeat.m2505o(110814);
        }

        /* renamed from: EI */
        public final void mo9102EI(int i) {
            AppMethodBeat.m2504i(110815);
            C35259a c35259a = C35251l.spJ;
            C4990ab.m7416i(C35251l.TAG, "onPostStart ".concat(String.valueOf(i)));
            if (this.spK.czr) {
                if (this.spK.spt) {
                    this.spK.setNeedReset(true);
                    AppMethodBeat.m2505o(110815);
                    return;
                }
                C39876h l = this.spK.sps;
                if (l != null) {
                    l.czC();
                }
                if (this.spK.spr.size() == 1 && ((ArrayList) this.spK.spr.get(0)).size() > 0) {
                    this.spK.setCurrentHItem(0);
                }
                if (this.spK.spr.size() == 1 && ((ArrayList) this.spK.spr.get(0)).size() == 1) {
                    C5004al.m7441d(new C4190a(this, i));
                }
            }
            AppMethodBeat.m2505o(110815);
        }

        public final void cwW() {
            AppMethodBeat.m2504i(110816);
            C43642a c43642a = C43641i.rSv;
            C7305d.post(C43643b.rSx, "Story_cleanAudioFile");
            if (this.spK.czr) {
                if (this.spK.spt) {
                    this.spK.setNeedReset(true);
                    AppMethodBeat.m2505o(110816);
                    return;
                }
                C39876h l = this.spK.sps;
                if (l != null) {
                    l.czC();
                    AppMethodBeat.m2505o(110816);
                    return;
                }
            }
            AppMethodBeat.m2505o(110816);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.gallery.l$n */
    static final class C4191n implements Runnable {
        final /* synthetic */ int exi;
        final /* synthetic */ C35251l spK;

        C4191n(C35251l c35251l, int i) {
            this.spK = c35251l;
            this.exi = i;
        }

        public final void run() {
            AppMethodBeat.m2504i(110817);
            C35259a c35259a = C35251l.spJ;
            C4990ab.m7410d(C35251l.TAG, "setCurrentHItem=" + this.spK.rZb + " galleryGroups.size=" + this.spK.spr.size() + " galleryGroups[selectedRow].size=" + ((ArrayList) this.spK.spr.get(this.spK.rZb)).size() + " hRecyclerView=" + this.spK.spi);
            RecyclerView i = this.spK.spi;
            if (i != null) {
                i.mo61465bY(this.exi);
                AppMethodBeat.m2505o(110817);
                return;
            }
            AppMethodBeat.m2505o(110817);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&¨\u0006\u0007"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryView$IOnGalleryScale;", "", "onBgAlpha", "", "alpha", "", "onGalleryExitFromTop", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.gallery.l$b */
    public interface C13884b {
        /* renamed from: bc */
        void mo26102bc(float f);

        void cCg();
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, dWq = {"com/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryView$fadeInMaskView$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationStart", "", "p0", "Landroid/animation/Animator;", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.gallery.l$e */
    public static final class C13885e extends AnimatorListenerAdapter {
        final /* synthetic */ C35251l spK;

        C13885e(C35251l c35251l) {
            this.spK = c35251l;
        }

        public final void onAnimationStart(Animator animator) {
            AppMethodBeat.m2504i(110789);
            this.spK.iVh.setVisibility(0);
            AppMethodBeat.m2505o(110789);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, dWq = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.gallery.l$k */
    static final class C13889k implements OnClickListener {
        final /* synthetic */ C35251l spK;

        C13889k(C35251l c35251l) {
            this.spK = c35251l;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(138951);
            C39876h l = this.spK.sps;
            if (l != null) {
                boolean z;
                int g = this.spK.rZb;
                int m = this.spK.spn;
                C29366a o = this.spK.spy;
                if (o != null) {
                    z = o.rYr;
                } else {
                    z = false;
                }
                l.mo37754o(g, m, z);
                AppMethodBeat.m2505o(138951);
                return;
            }
            AppMethodBeat.m2505o(138951);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, dWq = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.gallery.l$l */
    static final class C13890l implements OnClickListener {
        final /* synthetic */ C35251l spK;

        C13890l(C35251l c35251l) {
            this.spK = c35251l;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(110812);
            C39876h l = this.spK.sps;
            if (l != null) {
                boolean z;
                int g = this.spK.rZb;
                int m = this.spK.spn;
                C29366a o = this.spK.spy;
                if (o != null) {
                    z = o.rvv;
                } else {
                    z = false;
                }
                l.mo37753n(g, m, z);
                AppMethodBeat.m2505o(110812);
                return;
            }
            AppMethodBeat.m2505o(110812);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "view", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.gallery.l$2 */
    static final class C223132 implements View.OnClickListener {
        final /* synthetic */ C35251l spK;

        C223132(C35251l c35251l) {
            this.spK = c35251l;
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(138942);
            if (this.spK.spr.size() == 1 && ((ArrayList) this.spK.spr.get(0)).isEmpty()) {
                C35171g p = this.spK.spu;
                if (p != null) {
                    p.caC();
                    AppMethodBeat.m2505o(138942);
                    return;
                }
            }
            AppMethodBeat.m2505o(138942);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.gallery.l$d */
    static final class C29372d implements Runnable {
        final /* synthetic */ C35251l spK;

        C29372d(C35251l c35251l) {
            this.spK = c35251l;
        }

        public final void run() {
            AppMethodBeat.m2504i(110788);
            StoryGalleryItemView A = this.spK.sph;
            if (A == null || A.getVideoItem() == null) {
                AppMethodBeat.m2505o(110788);
                return;
            }
            C4133a c4133a = C43644j.rST;
            C46275k cxT = C4133a.cxT();
            StoryGalleryItemView A2 = this.spK.sph;
            if (A2 == null) {
                C25052j.dWJ();
            }
            C35201i videoItem = A2.getVideoItem();
            if (videoItem == null) {
                C25052j.dWJ();
            }
            int b = C46275k.m86720b(cxT, videoItem.rUJ);
            C35259a c35259a = C35251l.spJ;
            String access$getTAG$cp = C35251l.TAG;
            StringBuilder stringBuilder = new StringBuilder("storyId :");
            StoryGalleryItemView A3 = this.spK.sph;
            if (A3 == null) {
                C25052j.dWJ();
            }
            C35201i videoItem2 = A3.getVideoItem();
            if (videoItem2 == null) {
                C25052j.dWJ();
            }
            C4990ab.m7416i(access$getTAG$cp, stringBuilder.append(videoItem2.rUJ).append(" read times + 1  ,result:").append(b).toString());
            AppMethodBeat.m2505o(110788);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, dWq = {"com/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryView$fadeOutMaskView$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "p0", "Landroid/animation/Animator;", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.gallery.l$f */
    public static final class C29373f extends AnimatorListenerAdapter {
        final /* synthetic */ C35251l spK;

        C29373f(C35251l c35251l) {
            this.spK = c35251l;
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.m2504i(110790);
            this.spK.iVh.setVisibility(8);
            AppMethodBeat.m2505o(110790);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.gallery.l$8 */
    static final class C315738 extends C25053k implements C31214a<Boolean> {
        public static final C315738 spM = new C315738();

        static {
            AppMethodBeat.m2504i(138950);
            AppMethodBeat.m2505o(138950);
        }

        C315738() {
            super(0);
        }

        public final /* bridge */ /* synthetic */ Object invoke() {
            return Boolean.TRUE;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.gallery.l$c */
    static final class C31574c extends C25053k implements C31214a<C37091y> {
        final /* synthetic */ C35251l spK;

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
        /* renamed from: com.tencent.mm.plugin.story.ui.view.gallery.l$c$1 */
        static final class C315751 extends C25053k implements C31214a<C37091y> {
            final /* synthetic */ C31574c spN;

            C315751(C31574c c31574c) {
                this.spN = c31574c;
                super(0);
            }

            public final /* synthetic */ Object invoke() {
                AppMethodBeat.m2504i(110786);
                C39876h l = this.spN.spK.sps;
                if (l != null) {
                    l.czC();
                }
                C37091y c37091y = C37091y.AUy;
                AppMethodBeat.m2505o(110786);
                return c37091y;
            }
        }

        C31574c(C35251l c35251l) {
            this.spK = c35251l;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(110787);
            C35259a c35259a = C35251l.spJ;
            C4990ab.m7416i(C35251l.TAG, "is receive a message to update");
            if (this.spK.czr) {
                if (this.spK.spt) {
                    c35259a = C35251l.spJ;
                    C4990ab.m7416i(C35251l.TAG, "is receive a message to update but is was not allow ");
                    this.spK.setNeedReset(true);
                } else {
                    c35259a = C35251l.spJ;
                    C4990ab.m7416i(C35251l.TAG, "is receive a message to update and do it  ");
                    C8902b.m16042a(new C315751(this));
                }
            }
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(110787);
            return c37091y;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.gallery.l$o */
    static final class C35250o implements Runnable {
        final /* synthetic */ int exi;
        final /* synthetic */ C35251l spK;

        C35250o(C35251l c35251l, int i) {
            this.spK = c35251l;
            this.exi = i;
        }

        public final void run() {
            AppMethodBeat.m2504i(110818);
            this.spK.spq.mo61465bY(this.exi);
            AppMethodBeat.m2505o(110818);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\n\u001a\u00020\u0003H\u0016J \u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0005H\u0016J \u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0005H\u0016J \u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0005H\u0016J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\bH\u0016J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\bH\u0016J\u001e\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016H\u0016J\u0010\u0010\u0018\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0005H\u0016¨\u0006\u0019"}, dWq = {"com/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryView$galleryGroupUpdateCallback$1", "Lcom/tencent/mm/plugin/story/presenter/GalleryGroupUpdateCallback;", "deleteGroup", "", "groupIndex", "", "notifyDeleteResult", "isOk", "", "notifyGroup", "notifyIndicator", "notifyItemsChange", "start", "count", "notifyItemsInsert", "notifyItemsRemove", "notifySetFavResult", "favorite", "notifySetPrivacyResult", "isPrivacy", "updateGroup", "items", "", "Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItem;", "updateGroupCount", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.gallery.l$g */
    public static final class C35252g implements C43632e {
        final /* synthetic */ Context jWS;
        final /* synthetic */ C35251l spK;

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
        /* renamed from: com.tencent.mm.plugin.story.ui.view.gallery.l$g$b */
        static final class C13886b implements Runnable {
            final /* synthetic */ C35252g spO;
            final /* synthetic */ int spP;

            C13886b(C35252g c35252g, int i) {
                this.spO = c35252g;
                this.spP = i;
            }

            public final void run() {
                AppMethodBeat.m2504i(110792);
                this.spO.spK.tBv.mo66316cg(this.spP);
                AppMethodBeat.m2505o(110792);
            }
        }

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
        /* renamed from: com.tencent.mm.plugin.story.ui.view.gallery.l$g$c */
        static final class C13887c implements Runnable {
            final /* synthetic */ C35252g spO;
            final /* synthetic */ int spP;

            C13887c(C35252g c35252g, int i) {
                this.spO = c35252g;
                this.spP = i;
            }

            public final void run() {
                AppMethodBeat.m2504i(110793);
                this.spO.spK.tBv.mo66316cg(this.spP);
                AppMethodBeat.m2505o(110793);
            }
        }

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
        /* renamed from: com.tencent.mm.plugin.story.ui.view.gallery.l$g$e */
        static final class C13888e implements Runnable {
            final /* synthetic */ C35252g spO;

            C13888e(C35252g c35252g) {
                this.spO = c35252g;
            }

            public final void run() {
                AppMethodBeat.m2504i(110795);
                C35251l c35251l = this.spO.spK;
                C5127a c5127a = null;
                if (c35251l.soE == C29273a.ProfileGallery) {
                    c5127a = C5127a.USERINFO_STORY_PULL_DOWN_PROFILE_FIRST_BOOLEAN_SYNC;
                }
                if (c5127a != null) {
                    C1706e RP = C1720g.m3536RP();
                    C25052j.m39375o(RP, "storage()");
                    if (!RP.mo5239Ry().getBoolean(c5127a, false)) {
                        LayoutParams layoutParams = c35251l.spg.getLayoutParams();
                        if (layoutParams == null) {
                            C44941v c44941v = new C44941v("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                            AppMethodBeat.m2505o(110795);
                            throw c44941v;
                        }
                        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) layoutParams;
                        C5230ak.m7989hF(c35251l.getContext());
                        marginLayoutParams.topMargin = -c35251l.getTop();
                        c35251l.spg.setLayoutParams(marginLayoutParams);
                        c35251l.spg.setVisibility(0);
                        TextView textView = c35251l.spg;
                        String string = c35251l.getResources().getString(C25738R.string.etc);
                        C25052j.m39375o(string, "resources.getString(R.string.story_pull_hint)");
                        textView.setText(C35259a.m57931l(string, c35251l.spg.getCurrentTextColor()));
                    }
                }
                AppMethodBeat.m2505o(110795);
            }
        }

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
        /* renamed from: com.tencent.mm.plugin.story.ui.view.gallery.l$g$a */
        static final class C29374a implements Runnable {
            final /* synthetic */ C35252g spO;
            final /* synthetic */ int spP;

            C29374a(C35252g c35252g, int i) {
                this.spO = c35252g;
                this.spP = i;
            }

            public final void run() {
                AppMethodBeat.m2504i(110791);
                this.spO.spK.tBv.mo66316cg(this.spP);
                AppMethodBeat.m2505o(110791);
            }
        }

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
        /* renamed from: com.tencent.mm.plugin.story.ui.view.gallery.l$g$d */
        static final class C29375d implements Runnable {
            final /* synthetic */ C35252g spO;
            final /* synthetic */ int spP;

            C29375d(C35252g c35252g, int i) {
                this.spO = c35252g;
                this.spP = i;
            }

            public final void run() {
                AppMethodBeat.m2504i(110794);
                this.spO.spK.tBv.mo66316cg(this.spP);
                AppMethodBeat.m2505o(110794);
            }
        }

        C35252g(C35251l c35251l, Context context) {
            this.spK = c35251l;
            this.jWS = context;
        }

        /* renamed from: lB */
        public final void mo55974lB(boolean z) {
            AppMethodBeat.m2504i(110796);
            this.spK.spx.mo55917lU(z);
            AppMethodBeat.m2505o(110796);
        }

        /* renamed from: lA */
        public final void mo55973lA(boolean z) {
            AppMethodBeat.m2504i(110797);
            this.spK.spx.mo55916lT(z);
            AppMethodBeat.m2505o(110797);
        }

        /* renamed from: lz */
        public final void mo55975lz(boolean z) {
            AppMethodBeat.m2504i(110798);
            C44275p n = this.spK.tipDialog;
            if (n != null) {
                n.dismiss();
            }
            if (z) {
                C13774d c13774d = C13774d.rSg;
                C13774d.cxB();
                AppMethodBeat.m2505o(110798);
                return;
            }
            C23639t.makeText(this.jWS, this.jWS.getResources().getString(C25738R.string.esg), 0).show();
            AppMethodBeat.m2505o(110798);
        }

        /* renamed from: EP */
        public final void mo55965EP(int i) {
            AppMethodBeat.m2504i(110799);
            if (i <= 1) {
                this.spK.spA.cCG();
            }
            this.spK.spr.clear();
            for (int i2 = 0; i2 < i; i2++) {
                this.spK.spr.add(new ArrayList());
            }
            AppMethodBeat.m2505o(110799);
        }

        /* renamed from: j */
        public final void mo55972j(int i, List<C43640g> list) {
            AppMethodBeat.m2504i(110800);
            C25052j.m39376p(list, "items");
            C35259a c35259a = C35251l.spJ;
            C4990ab.m7409c(C35251l.TAG, "updateGroup, groupIndex:" + i + ", items:" + list.size() + ", active:" + this.spK.spt + ", galleryType:" + this.spK.getGalleryType(), new Object[0]);
            if (i >= this.spK.spr.size()) {
                AppMethodBeat.m2505o(110800);
                return;
            }
            ((ArrayList) this.spK.spr.get(i)).clear();
            ((ArrayList) this.spK.spr.get(i)).addAll(list);
            this.spK.tBv.mo26079dI(this.spK.spr);
            if (this.spK.rZb == i) {
                C29324g x = this.spK.spk;
                if (x != null) {
                    x.mo47527dI(list);
                }
            }
            C35171g p;
            if (this.spK.spr.size() == 1 && list.isEmpty()) {
                p = this.spK.spu;
                if (p != null) {
                    p.caA();
                }
                this.spK.iVh.setVisibility(8);
                if (this.spK.getGalleryType() == C29273a.SelfTabGallery) {
                    this.spK.spz.setVisibility(0);
                    C22212h c22212h = C22212h.scu;
                    C22212h.cAw().mo60517bE(1);
                    c22212h = C22212h.scu;
                    C22212h.cAx();
                } else {
                    this.spK.spz.setVisibility(8);
                }
            } else {
                this.spK.post(new C13888e(this));
                p = this.spK.spu;
                if (p != null) {
                    p.caB();
                }
                this.spK.spz.setVisibility(8);
                if (!this.spK.spt) {
                    this.spK.iVh.setAlpha(1.0f);
                    this.spK.iVh.setVisibility(0);
                }
            }
            if (i != 0 || this.spK.spt || this.spK.getGalleryType() == C29273a.HistoryGallery || this.spK.getGalleryType() == C29273a.MultiUserGallery) {
                if (i == 1) {
                    this.spK.getGalleryType();
                    C29273a c29273a = C29273a.MultiUserGallery;
                }
                AppMethodBeat.m2505o(110800);
                return;
            }
            this.spK.mo55931Fk(0);
            AppMethodBeat.m2505o(110800);
        }

        /* renamed from: EQ */
        public final void mo55966EQ(int i) {
            AppMethodBeat.m2504i(110801);
            C35259a c35259a = C35251l.spJ;
            C4990ab.m7416i(C35251l.TAG, "deleteGroup: exitCheck " + this.spK.getDeleteWhenFirstEmpty() + ' ' + i + ' ' + this.spK.rZb);
            int i2 = (this.spK.getDeleteWhenFirstEmpty() && i == 0 && this.spK.rZb <= 0) ? 1 : 0;
            C35171g p;
            if (i2 != 0) {
                p = this.spK.spu;
                if (p != null) {
                    p.caC();
                    AppMethodBeat.m2505o(110801);
                    return;
                }
                AppMethodBeat.m2505o(110801);
                return;
            }
            i2 = this.spK.spr.size();
            if (i >= 0 && i2 > i) {
                this.spK.spr.remove(i);
                this.spK.tBv.mo26079dI(this.spK.spr);
                this.spK.tBv.mo66318ci(i);
                C13814d c13814d = this.spK.spx.soF;
                if (c13814d != null && i >= 0 && i < c13814d.iLD.size() - 2) {
                    c13814d.iLD.remove(i + 1);
                    c13814d.mo66318ci(i + 1);
                }
            }
            if (this.spK.spr.size() <= 1) {
                this.spK.spA.cCG();
            }
            if (this.spK.spr.isEmpty()) {
                p = this.spK.spu;
                if (p != null) {
                    p.caA();
                }
                this.spK.iVh.setVisibility(8);
                AppMethodBeat.m2505o(110801);
                return;
            }
            p = this.spK.spu;
            if (p != null) {
                p.caB();
            }
            if (!this.spK.spt) {
                this.spK.iVh.setAlpha(1.0f);
                this.spK.iVh.setVisibility(0);
            }
            AppMethodBeat.m2505o(110801);
        }

        /* renamed from: ER */
        public final void mo55967ER(int i) {
            AppMethodBeat.m2504i(110802);
            C35259a c35259a = C35251l.spJ;
            C4990ab.m7409c(C35251l.TAG, "notifyGroup, groupIndex:" + i + ", selectedRow:" + this.spK.rZb, new Object[0]);
            if (this.spK.rZb == i) {
                C29324g x = this.spK.spk;
                if (x != null) {
                    x.notifyDataSetChanged();
                    AppMethodBeat.m2505o(110802);
                    return;
                }
                AppMethodBeat.m2505o(110802);
                return;
            }
            this.spK.spq.post(new C29374a(this, i));
            AppMethodBeat.m2505o(110802);
        }

        /* renamed from: ai */
        public final void mo55968ai(int i, int i2, int i3) {
            AppMethodBeat.m2504i(110803);
            if (this.spK.rZb == i) {
                C29324g x = this.spK.spk;
                if (x != null) {
                    x.mo66310at(i2, i3);
                    AppMethodBeat.m2505o(110803);
                    return;
                }
                AppMethodBeat.m2505o(110803);
                return;
            }
            this.spK.spq.post(new C13887c(this, i));
            AppMethodBeat.m2505o(110803);
        }

        /* renamed from: aj */
        public final void mo55969aj(int i, int i2, int i3) {
            AppMethodBeat.m2504i(110804);
            if (this.spK.rZb == i) {
                C29324g x = this.spK.spk;
                if (x != null) {
                    x.mo66311au(i2, i3);
                    AppMethodBeat.m2505o(110804);
                    return;
                }
                AppMethodBeat.m2505o(110804);
                return;
            }
            this.spK.spq.post(new C29375d(this, i));
            AppMethodBeat.m2505o(110804);
        }

        /* renamed from: ak */
        public final void mo55970ak(int i, int i2, int i3) {
            AppMethodBeat.m2504i(110805);
            if (this.spK.rZb == i) {
                C29324g x = this.spK.spk;
                if (x != null) {
                    x.mo66308ar(i2, i3);
                    AppMethodBeat.m2505o(110805);
                    return;
                }
                AppMethodBeat.m2505o(110805);
                return;
            }
            this.spK.spq.post(new C13886b(this, i));
            AppMethodBeat.m2505o(110805);
        }

        public final void czD() {
            AppMethodBeat.m2504i(110806);
            int size = this.spK.spr.size();
            int g = this.spK.rZb;
            if (g < 0) {
                AppMethodBeat.m2505o(110806);
                return;
            }
            if (size > g) {
                GalleryHorizontalControlView z = this.spK.spj;
                if (z != null) {
                    Object obj = this.spK.spr.get(this.spK.rZb);
                    C25052j.m39375o(obj, "galleryGroups[selectedRow]");
                    z.mo55908dI((List) obj);
                    AppMethodBeat.m2505o(110806);
                    return;
                }
            }
            AppMethodBeat.m2505o(110806);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, dWq = {"<anonymous>", "", "it", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.gallery.l$i */
    static final class C35253i extends C25053k implements C17126b<Integer, C37091y> {
        final /* synthetic */ C35251l spK;

        C35253i(C35251l c35251l) {
            this.spK = c35251l;
            super(1);
        }

        /* renamed from: am */
        public final /* synthetic */ Object mo50am(Object obj) {
            boolean z;
            boolean z2 = true;
            AppMethodBeat.m2504i(110809);
            int intValue = ((Number) obj).intValue();
            this.spK.shh = intValue == 3;
            GalleryRecyclerView d = this.spK.spq;
            if (this.spK.shh) {
                z = false;
            } else {
                z = true;
            }
            d.setScrollEnable(z);
            C35251l c35251l = this.spK;
            if (intValue == 1) {
                z = true;
            } else {
                z = false;
            }
            c35251l.shi = z;
            C5004al.m7439af(this.spK.shf.oBn);
            C4172f e = this.spK.shf;
            if (this.spK.shh) {
                z2 = false;
            }
            e.sof = z2;
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(110809);
            return c37091y;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\n¢\u0006\u0002\b\b"}, dWq = {"<anonymous>", "", "row", "", "rowView", "Landroid/support/v7/widget/RecyclerView;", "indicatorView", "Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryHorizontalControlView;", "invoke"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.gallery.l$3 */
    static final class C352543 extends C25053k implements C36933q<Integer, RecyclerView, GalleryHorizontalControlView, C37091y> {
        final /* synthetic */ C35251l spK;

        C352543(C35251l c35251l) {
            this.spK = c35251l;
            super(3);
        }

        /* renamed from: g */
        public final /* synthetic */ Object mo9028g(Object obj, Object obj2, Object obj3) {
            AppMethodBeat.m2504i(138943);
            C35251l.m57871a(this.spK, ((Number) obj).intValue(), (RecyclerView) obj2, (GalleryHorizontalControlView) obj3);
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(138943);
            return c37091y;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, dWq = {"<anonymous>", "", "position", "", "offset", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.gallery.l$4 */
    static final class C352554 extends C25053k implements C31591m<Integer, Float, C37091y> {
        final /* synthetic */ C35251l spK;

        C352554(C35251l c35251l) {
            this.spK = c35251l;
            super(2);
        }

        /* renamed from: m */
        public final /* synthetic */ Object mo212m(Object obj, Object obj2) {
            AppMethodBeat.m2504i(138944);
            int intValue = ((Number) obj).intValue();
            float floatValue = ((Number) obj2).floatValue();
            this.spK.spo = ((float) intValue) + floatValue;
            GalleryVerticalControlView q = this.spK.spx;
            int i = intValue + 1;
            floatValue = 1.0f - floatValue;
            if (q.soE == C29273a.MultiUserGallery) {
                intValue = C1338a.fromDPToPix(q.getContext(), 52);
            } else {
                intValue = C1338a.fromDPToPix(q.getContext(), 32);
            }
            C22261a c22261a = q.soG;
            if (c22261a != null) {
                c22261a.mo1757ah(i, (int) (((float) intValue) * floatValue));
            }
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(138944);
            return c37091y;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, dWq = {"<anonymous>", "", "position", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.gallery.l$5 */
    static final class C352565 extends C25053k implements C17126b<Integer, C37091y> {
        final /* synthetic */ C35251l spK;

        C352565(C35251l c35251l) {
            this.spK = c35251l;
            super(1);
        }

        /* renamed from: am */
        public final /* synthetic */ Object mo50am(Object obj) {
            AppMethodBeat.m2504i(138945);
            int intValue = ((Number) obj).intValue();
            C39876h l = this.spK.sps;
            if (l != null) {
                l.mo37741ES(intValue);
            }
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(138945);
            return c37091y;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.gallery.l$6 */
    static final class C352576 extends C25053k implements C31214a<C37091y> {
        final /* synthetic */ C35251l spK;

        C352576(C35251l c35251l) {
            this.spK = c35251l;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(110782);
            if (this.spK.soz != null) {
                C22212h c22212h = C22212h.scu;
                C22212h.m33888EX(12);
                C13884b r = this.spK.soz;
                if (r != null) {
                    r.cCg();
                }
            } else {
                C35171g p = this.spK.spu;
                if (p != null) {
                    p.caC();
                }
            }
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(110782);
            return c37091y;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J.\u0010\u0007\u001a\u00020\u00032\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0016\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\n0\fj\b\u0012\u0004\u0012\u00020\n`\rH\u0016J\u001a\u0010\u000e\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¨\u0006\u0010"}, dWq = {"com/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryView$setDataSeed$1", "Lcom/tencent/mm/plugin/story/api/IStoryStateFetcher$ChatRoomStateListener;", "updateChatRoomState", "", "hasStory", "", "hasUnread", "updateGalleryUserList", "userList", "", "", "unreadList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "updateUserState", "username", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.gallery.l$p */
    public static final class C35258p implements C29271a {
        final /* synthetic */ C35251l spK;
        final /* synthetic */ C31431d spT;

        C35258p(C35251l c35251l, C31431d c31431d) {
            this.spK = c35251l;
            this.spT = c31431d;
        }

        /* renamed from: a */
        public final void mo47450a(List<String> list, ArrayList<String> arrayList) {
            AppMethodBeat.m2504i(110819);
            C25052j.m39376p(list, "userList");
            C25052j.m39376p(arrayList, "unreadList");
            C35259a c35259a = C35251l.spJ;
            C4990ab.m7416i(C35251l.TAG, "updateGalleryUserList: " + list.size());
            C35251l.m57875a(this.spK, (Object) list);
            C4116b c4116b = C4116b.sbw;
            C4116b.m6439dF(list);
            this.spT.destroy();
            AppMethodBeat.m2505o(110819);
        }

        /* renamed from: L */
        public final void mo47449L(boolean z, boolean z2) {
        }

        /* renamed from: bs */
        public final void mo47451bs(String str, boolean z) {
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u0006XD¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u000e"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryView$Companion;", "", "()V", "ClickCountShowHint", "", "TAG", "", "getTAG", "()Ljava/lang/String;", "getPullDownSpan", "Landroid/text/SpannableString;", "text", "", "color", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.gallery.l$a */
    public static final class C35259a {
        private C35259a() {
        }

        public /* synthetic */ C35259a(byte b) {
            this();
        }

        /* renamed from: l */
        public static SpannableString m57931l(CharSequence charSequence, int i) {
            AppMethodBeat.m2504i(110784);
            C25052j.m39376p(charSequence, "text");
            Context context = C4996ah.getContext();
            Drawable f = C5225ah.m7962f(context, C1318a.story_downward_arrow, i);
            f.setBounds(0, 0, C1338a.fromDPToPix(context, 14), C1338a.fromDPToPix(context, 20));
            C5664a c5664a = new C5664a(f);
            SpannableString spannableString = new SpannableString("#" + charSequence);
            spannableString.setSpan(c5664a, 0, 1, 17);
            AppMethodBeat.m2505o(110784);
            return spannableString;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005H\n¢\u0006\u0002\b\u0007"}, dWq = {"<anonymous>", "", "bOk", "", "<anonymous parameter 1>", "", "kotlin.jvm.PlatformType", "onDialogClick"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.gallery.l$h */
    static final class C35260h implements C5662c {
        final /* synthetic */ C35251l spK;
        final /* synthetic */ C39879j spQ;

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
        /* renamed from: com.tencent.mm.plugin.story.ui.view.gallery.l$h$1 */
        static final class C352491 implements OnCancelListener {
            final /* synthetic */ C35260h spR;

            C352491(C35260h c35260h) {
                this.spR = c35260h;
            }

            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.m2504i(110807);
                C35259a c35259a = C35251l.spJ;
                C4990ab.m7416i(C35251l.TAG, "delete click and click cancel it " + this.spR.spK.rZb + ' ' + this.spR.spK.spn);
                C39876h l = this.spR.spK.sps;
                if (l != null) {
                    this.spR.spK.rZb;
                    this.spR.spK.spn;
                    l.czB();
                    AppMethodBeat.m2505o(110807);
                    return;
                }
                AppMethodBeat.m2505o(110807);
            }
        }

        C35260h(C35251l c35251l, C39879j c39879j) {
            this.spK = c35251l;
            this.spQ = c39879j;
        }

        /* renamed from: d */
        public final void mo5699d(boolean z, String str) {
            boolean z2 = false;
            AppMethodBeat.m2504i(110808);
            C35259a c35259a = C35251l.spJ;
            C4990ab.m7416i(C35251l.TAG, "delete click and click ok it " + this.spK.rZb + ' ' + this.spK.spn);
            if (z) {
                C39879j c39879j = this.spQ;
                if (c39879j != null) {
                    if (!(c39879j.field_storyID != 0)) {
                        c39879j = null;
                    }
                    if (c39879j != null) {
                        z2 = true;
                    }
                }
                C35251l c35251l = this.spK;
                Context context = this.spK.getContext();
                this.spK.getContext().getString(C25738R.string.f9238tz);
                c35251l.tipDialog = C30379h.m48458b(context, this.spK.getContext().getString(C25738R.string.esi), z2, (OnCancelListener) new C352491(this));
                C39876h l = this.spK.sps;
                if (l != null) {
                    l.mo37746fM(this.spK.rZb, this.spK.spn);
                    AppMethodBeat.m2505o(110808);
                    return;
                }
            }
            AppMethodBeat.m2505o(110808);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, dWq = {"<anonymous>", "", "position", "", "child", "Landroid/view/View;", "invoke"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.gallery.l$j */
    static final class C35261j extends C25053k implements C31591m<Integer, View, C37091y> {
        final /* synthetic */ C35251l spK;

        C35261j(C35251l c35251l) {
            this.spK = c35251l;
            super(2);
        }

        /* renamed from: m */
        public final /* synthetic */ Object mo212m(Object obj, Object obj2) {
            AppMethodBeat.m2504i(110810);
            int intValue = ((Number) obj).intValue();
            View view = (View) obj2;
            C25052j.m39376p(view, "child");
            C35251l.m57872a(this.spK, intValue, view);
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(110810);
            return c37091y;
        }
    }

    public /* synthetic */ C35251l(Context context, C29273a c29273a) {
        this(context, c29273a, 0, false);
    }

    public final int getExpectPos() {
        return this.rZE;
    }

    public final C29273a getGalleryType() {
        return this.soE;
    }

    public C35251l(final Context context, C29273a c29273a, int i, boolean z) {
        C25052j.m39376p(context, "context");
        C25052j.m39376p(c29273a, "galleryType");
        super(context);
        AppMethodBeat.m2504i(138953);
        this.soE = c29273a;
        this.rZE = i;
        this.spm = new C4185j();
        this.rZb = -1;
        this.spn = -1;
        this.dirty = true;
        this.spr = new ArrayList();
        this.spB = true;
        C4990ab.m7416i(TAG, " StoryGalleryView " + this.soE);
        C29380q c29380q = C29380q.srv;
        C22319p cDg = C29380q.cDg();
        if (cDg == null) {
            this.soY = new C22319p();
            this.spd = false;
        } else {
            this.spd = true;
            this.soY = cDg;
        }
        c29380q = C29380q.srv;
        C29380q.clean();
        this.spl = new C4185j();
        this.shf = new C4172f(context);
        View.inflate(context, 2130970889, this);
        View findViewById = findViewById(2131828158);
        C25052j.m39375o(findViewById, "findViewById(R.id.story_gallery_recycler)");
        this.spq = (GalleryRecyclerView) findViewById;
        findViewById = findViewById(2131828159);
        C25052j.m39375o(findViewById, "findViewById(R.id.story_gallery_mask_view)");
        this.iVh = findViewById;
        findViewById = findViewById(2131828162);
        C25052j.m39375o(findViewById, "findViewById(R.id.story_gallery_holder_layout)");
        this.spz = (GalleryHolderView) findViewById;
        findViewById = findViewById(2131828161);
        C25052j.m39375o(findViewById, "findViewById(R.id.story_gallery_control_layout)");
        this.spx = (GalleryVerticalControlView) findViewById;
        GalleryVerticalControlView.m57861a(this.spx, this.soE);
        LayoutParams layoutParams = this.spx.getLayoutParams();
        if (layoutParams == null) {
            C44941v c44941v = new C44941v("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            AppMethodBeat.m2505o(138953);
            throw c44941v;
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
        int i2 = layoutParams2.topMargin;
        if (C5222ae.m7950hD(context)) {
            i2 += C5222ae.m7949hC(context);
        }
        layoutParams2.setMargins(0, i2, 0, 0);
        this.spx.setLayoutParams(layoutParams2);
        findViewById = findViewById(2131828160);
        C25052j.m39375o(findViewById, "findViewById(R.id.story_pull_hint)");
        this.spg = (TextView) findViewById;
        this.spx.setOnAllFav(new C31214a<C37091y>(this) {
            final /* synthetic */ C35251l spK;

            public final /* synthetic */ Object invoke() {
                AppMethodBeat.m2504i(138941);
                int size = this.spK.spr.size();
                int g = this.spK.rZb;
                if (g >= 0 && size > g) {
                    size = ((ArrayList) this.spK.spr.get(this.spK.rZb)).size();
                    g = this.spK.spn;
                    if (g >= 0 && size > g) {
                        Intent intent = new Intent(context, StoryFavAlbumUI.class);
                        Object obj = ((ArrayList) this.spK.spr.get(this.spK.rZb)).get(this.spK.spn);
                        C25052j.m39375o(obj, "galleryGroups[selectedRow][selectedColumn]");
                        intent.putExtra("username", ((C43640g) obj).userName);
                        context.startActivity(intent);
                    }
                }
                C37091y c37091y = C37091y.AUy;
                AppMethodBeat.m2505o(138941);
                return c37091y;
            }
        });
        this.spx.mo55910a(this.soE, z);
        this.spz.setOnClickListener(new C223132(this));
        this.tBv = new C13879b();
        this.spq.setAdapter(this.tBv);
        this.spq.setFocusable(false);
        this.spq.setOnRowSelected(new C352543(this));
        this.spq.setOnScrollCallback(new C352554(this));
        this.tBv.tBr = new C352565(this);
        this.spx.setOnClose(new C352576(this));
        this.spx.setOnMenu(new C31214a<C37091y>(this) {
            final /* synthetic */ C35251l spK;

            @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
            /* renamed from: com.tencent.mm.plugin.story.ui.view.gallery.l$7$1 */
            static final class C41861 extends C25053k implements C31214a<C37091y> {
                final /* synthetic */ C223157 spL;

                C41861(C223157 c223157) {
                    this.spL = c223157;
                    super(0);
                }

                public final /* synthetic */ Object invoke() {
                    AppMethodBeat.m2504i(138946);
                    C35251l.m57899u(this.spL.spK);
                    C37091y c37091y = C37091y.AUy;
                    AppMethodBeat.m2505o(138946);
                    return c37091y;
                }
            }

            @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
            /* renamed from: com.tencent.mm.plugin.story.ui.view.gallery.l$7$2 */
            static final class C41872 extends C25053k implements C31214a<C37091y> {
                final /* synthetic */ C223157 spL;

                C41872(C223157 c223157) {
                    this.spL = c223157;
                    super(0);
                }

                public final /* synthetic */ Object invoke() {
                    AppMethodBeat.m2504i(138947);
                    C35251l.m57897s(this.spL.spK);
                    C37091y c37091y = C37091y.AUy;
                    AppMethodBeat.m2505o(138947);
                    return c37091y;
                }
            }

            @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
            /* renamed from: com.tencent.mm.plugin.story.ui.view.gallery.l$7$4 */
            static final class C223144 extends C25053k implements C31214a<C37091y> {
                final /* synthetic */ C223157 spL;

                C223144(C223157 c223157) {
                    this.spL = c223157;
                    super(0);
                }

                public final /* synthetic */ Object invoke() {
                    AppMethodBeat.m2504i(138949);
                    C35251l.m57898t(this.spL.spK);
                    C37091y c37091y = C37091y.AUy;
                    AppMethodBeat.m2505o(138949);
                    return c37091y;
                }
            }

            /* JADX WARNING: Removed duplicated region for block: B:105:0x01fa  */
            /* JADX WARNING: Removed duplicated region for block: B:31:0x00d2  */
            /* JADX WARNING: Removed duplicated region for block: B:33:0x00d5  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final /* synthetic */ Object invoke() {
                AppMethodBeat.m2504i(110783);
                if (this.spK.czr) {
                    int size = this.spK.spr.size();
                    int g = this.spK.rZb;
                    if (g >= 0 && size > g) {
                        size = ((ArrayList) this.spK.spr.get(this.spK.rZb)).size();
                        g = this.spK.spn;
                        if (g >= 0 && size > g) {
                            Object obj;
                            boolean z;
                            Object obj2 = ((ArrayList) this.spK.spr.get(this.spK.rZb)).get(this.spK.spn);
                            C25052j.m39375o(obj2, "galleryGroups[selectedRow][selectedColumn]");
                            final C43640g c43640g = (C43640g) obj2;
                            C29366a o = this.spK.spy;
                            if (o != null) {
                                o.dismiss();
                            }
                            this.spK.spy = new C29366a(context);
                            C4133a c4133a = C43644j.rST;
                            C39879j Fe = C4133a.cxT().mo74397Fe(c43640g.rVZ.cNE);
                            if (Fe != null) {
                                if ((Fe.cBT() ? Fe : null) != null) {
                                    o = this.spK.spy;
                                    if (o != null) {
                                        o.snw = true;
                                    }
                                }
                            }
                            if (Fe != null) {
                                if (Fe.field_storyID != 0) {
                                    if (((long) Fe.field_createTime) <= ((long) C1839cb.aaF()) - ((long) ((C13738a) C29274a.rQZ.mo53288Uw()).rRe)) {
                                        obj = 1;
                                    } else {
                                        obj = null;
                                    }
                                    if (obj == null) {
                                        obj = null;
                                        if ((obj == null ? Fe : null) != null) {
                                            o = this.spK.spy;
                                            if (o != null) {
                                                o.sny = false;
                                            }
                                        }
                                    }
                                }
                                obj = 1;
                                if (obj == null) {
                                }
                                if ((obj == null ? Fe : null) != null) {
                                }
                            }
                            if (Fe != null) {
                                obj = (Fe.field_storyID == 0 || Fe.cBX()) ? 1 : null;
                                if ((obj != null ? Fe : null) != null) {
                                    o = this.spK.spy;
                                    if (o != null) {
                                        o.snx = false;
                                    }
                                }
                            }
                            if (this.spK.getGalleryType() == C29273a.FavSelfStoryGallery) {
                                o = this.spK.spy;
                                if (o != null) {
                                    o.ixx = false;
                                }
                            }
                            C29366a o2 = this.spK.spy;
                            if (o2 != null) {
                                if (Fe == null || !Fe.cBV() || Fe.cBX()) {
                                    z = false;
                                } else {
                                    z = true;
                                }
                                o2.rvv = z;
                            }
                            o2 = this.spK.spy;
                            if (o2 != null) {
                                if (Fe == null || !Fe.cBW()) {
                                    z = false;
                                } else {
                                    z = true;
                                }
                                o2.rYr = z;
                            }
                            o = this.spK.spy;
                            if (o != null && o.rvv) {
                                o = this.spK.spy;
                                if (o != null) {
                                    o.sny = false;
                                }
                            }
                            o = this.spK.spy;
                            if (o != null && o.rYr) {
                                o = this.spK.spy;
                                if (o != null) {
                                    o.snx = false;
                                }
                            }
                            o2 = this.spK.spy;
                            if (o2 != null) {
                                o2.sns = new C41872(this);
                            }
                            o2 = this.spK.spy;
                            if (o2 != null) {
                                o2.snt = new C31214a<C37091y>(this) {
                                    final /* synthetic */ C223157 spL;

                                    public final /* synthetic */ Object invoke() {
                                        AppMethodBeat.m2504i(138948);
                                        C35251l.m57882e(c43640g.rVZ);
                                        C37091y c37091y = C37091y.AUy;
                                        AppMethodBeat.m2505o(138948);
                                        return c37091y;
                                    }
                                };
                            }
                            o = this.spK.spy;
                            if (o != null) {
                                o.snu = new C223144(this);
                            }
                            o = this.spK.spy;
                            if (o != null) {
                                o.snv = new C41861(this);
                            }
                            C29366a o3 = this.spK.spy;
                            if (o3 != null) {
                                o3.show();
                            }
                            this.spK.shi = true;
                            C22212h c22212h = C22212h.scu;
                            C22212h.cAw().mo60517bE(7);
                            c22212h = C22212h.scu;
                            C22212h.cAw().mo60518fz(String.valueOf(Fe != null ? Long.valueOf(Fe.field_storyID) : null));
                            c22212h = C22212h.scu;
                            C22212h.cAx();
                        }
                    }
                }
                C37091y c37091y = C37091y.AUy;
                AppMethodBeat.m2505o(110783);
                return c37091y;
            }
        });
        this.skn = C315738.spM;
        C29304c c29304c = C29304c.rSd;
        C29304c.m46523a(this);
        this.spA = new C4175g(this, this.spq, this.spm);
        C22212h c22212h = C22212h.scu;
        C22212h.cAs().mo20742bF((long) C5023at.m7472gC(context));
        this.spC = new C35252g(this, context);
        this.spD = -1;
        this.spH = new C4189m(this);
        this.spI = new C29372d(this);
        AppMethodBeat.m2505o(138953);
    }

    static {
        AppMethodBeat.m2504i(110849);
        AppMethodBeat.m2505o(110849);
    }

    public final boolean getVideoViewMgrFromPreLoad() {
        return this.spd;
    }

    public final void setVideoViewMgrFromPreLoad(boolean z) {
        this.spd = z;
    }

    public final boolean getDeleteWhenFirstEmpty() {
        return this.spe;
    }

    public final void setDeleteWhenFirstEmpty(boolean z) {
        this.spe = z;
    }

    public final String getChatRoom() {
        return this.gpx;
    }

    public final void setChatRoom(String str) {
        AppMethodBeat.m2504i(110820);
        this.gpx = str;
        this.spx.setChatRoom(str);
        AppMethodBeat.m2505o(110820);
    }

    public final String getSessionId() {
        return this.cvF;
    }

    public final void setSessionId(String str) {
        this.cvF = str;
    }

    public final void setForSns(boolean z) {
        this.rZI = z;
    }

    public final void setGalleryScaleListener(C13884b c13884b) {
        AppMethodBeat.m2504i(110821);
        C25052j.m39376p(c13884b, CastExtraArgs.LISTENER);
        this.soz = c13884b;
        if (this.soE == C29273a.MultiUserGallery || this.soE == C29273a.HistoryGallery || this.soE == C29273a.FavSelfStoryGallery || this.soE == C29273a.FavOtherStoryGallery) {
            C36822d c36822d = new C36822d();
            c36822d.seu = this;
            this.shf.mo9092a((C35248e) c36822d);
        }
        this.shf.mo9092a((C35248e) new C4181h(this, c13884b));
        AppMethodBeat.m2505o(110821);
    }

    /* renamed from: Fk */
    public final void mo55931Fk(int i) {
        AppMethodBeat.m2504i(110822);
        if (this.spr.size() > 0 && ((ArrayList) this.spr.get(0)).size() > i) {
            C4990ab.m7409c(TAG, "checkDoPreloadBeforeEnterGallery", new Object[0]);
            if (((ArrayList) this.spr.get(0)).size() > i && !C5046bo.isNullOrNil(((C43640g) ((ArrayList) this.spr.get(0)).get(i)).rVZ.rWj.Url)) {
                C4990ab.m7416i(TAG, "checkDoPreloadBeforeEnterGallery, add [0," + i + "] item");
                C39933n c39933n = C39933n.sqi;
                C39933n.m68381dK(C7987l.m14170U(((C43640g) ((ArrayList) this.spr.get(0)).get(i)).rVZ));
                AppMethodBeat.m2505o(110822);
                return;
            }
        }
        AppMethodBeat.m2505o(110822);
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x006c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        AppMethodBeat.m2504i(110823);
        C25052j.m39376p(motionEvent, "ev");
        if (this.spt) {
            boolean dispatchTouchEvent;
            MotionEvent obtain;
            C4175g c4175g = this.spA;
            if (c4175g.soj) {
                C1706e RP = C1720g.m3536RP();
                C25052j.m39375o(RP, "storage()");
                RP.mo5239Ry().set(C5127a.USERINFO_STORY_GALLERY_FIRST_BOOLEAN_SYNC, Boolean.TRUE);
                c4175g.cCG();
            }
            switch (motionEvent.getActionMasked()) {
                case 0:
                    this.shj = false;
                    break;
                case 1:
                case 3:
                    break;
            }
            this.shi = false;
            this.shf.mo9091J(motionEvent);
            int i = this.shf.sod;
            if (!(this.shi || this.shh)) {
                int i2;
                if (this.rZb < 0 || this.rZb >= this.spr.size()) {
                    i2 = 0;
                } else {
                    int i3;
                    if (this.spo > 0.0f) {
                        i3 = 2;
                    } else {
                        i3 = 0;
                    }
                    if (this.spo < ((float) (this.spr.size() - 1))) {
                        i3 |= 1;
                    }
                    if (this.spn > 0) {
                        i2 = i3 | 8;
                    } else {
                        i2 = i3;
                    }
                    if (this.spn < ((ArrayList) this.spr.get(this.rZb)).size() - 1) {
                        i2 |= 4;
                    }
                }
                if ((i2 & i) == 0) {
                    dispatchTouchEvent = this.shf.dispatchTouchEvent(motionEvent);
                    if (!this.shi || dispatchTouchEvent) {
                        if (!this.shj) {
                            obtain = MotionEvent.obtain(motionEvent);
                            C25052j.m39375o(obtain, "cancelEvent");
                            obtain.setAction(3);
                            super.dispatchTouchEvent(obtain);
                            obtain.recycle();
                            this.shj = true;
                        }
                        AppMethodBeat.m2505o(110823);
                        return true;
                    }
                    if (!this.shh) {
                        C22262b layoutManager = this.spq.getLayoutManager();
                        C4173a c4173a = C4172f.soh;
                        if ((i & 4) == 0 && (i & 8) == 0) {
                            dispatchTouchEvent = false;
                        } else {
                            dispatchTouchEvent = true;
                        }
                        if (!dispatchTouchEvent) {
                            z = true;
                        }
                        layoutManager.shc = z;
                    }
                    boolean dispatchTouchEvent2 = super.dispatchTouchEvent(motionEvent);
                    AppMethodBeat.m2505o(110823);
                    return dispatchTouchEvent2;
                }
            }
            if (!this.shj) {
                obtain = MotionEvent.obtain(motionEvent);
                C25052j.m39375o(obtain, "cancelEvent");
                obtain.setAction(3);
                this.shf.dispatchTouchEvent(obtain);
                obtain.recycle();
                this.shj = true;
            }
            dispatchTouchEvent = false;
            if (this.shi) {
            }
            if (this.shj) {
            }
            AppMethodBeat.m2505o(110823);
            return true;
        }
        AppMethodBeat.m2505o(110823);
        return false;
    }

    public final boolean canScrollHorizontally(int i) {
        return this.spt;
    }

    private final void cCJ() {
        AppMethodBeat.m2504i(110824);
        C4990ab.m7410d(TAG, "fadeOutMaskView");
        C22212h c22212h = C22212h.scu;
        C22212h.cAs().mo20745bI(System.currentTimeMillis());
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.iVh, "alpha", new float[]{1.0f, 0.0f});
        ofFloat.addListener(new C29373f(this));
        ofFloat.start();
        AppMethodBeat.m2505o(110824);
    }

    public final void setNeedReset(boolean z) {
        this.spF = z;
    }

    public final void setFirstPost(boolean z) {
        this.spG = z;
    }

    /* JADX WARNING: Missing block: B:3:0x0014, code skipped:
            if (p000a.p005f.p007b.C25052j.m39373j(com.tencent.p177mm.plugin.story.model.C43644j.C4133a.cnk(), r5) == false) goto L_0x0016;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void setDataSeed(Object obj) {
        boolean z;
        String str;
        AppMethodBeat.m2504i(110825);
        if (obj instanceof String) {
            C4133a c4133a = C43644j.rST;
        }
        if (!(this.soE == C29273a.HistoryGallery || this.soE == C29273a.FavSelfStoryGallery)) {
            z = false;
            this.czr = z;
            str = this.gpx;
            if (str == null && (obj instanceof ArrayList) && ((ArrayList) obj).isEmpty()) {
                C4990ab.m7416i(TAG, "setDataSeed: chat room empty user list, fetch again");
                C31431d c31431d = new C31431d(str);
                c31431d.rXb = new C35258p(this, c31431d);
                c31431d.start();
                AppMethodBeat.m2505o(110825);
                return;
            }
            setDataInternal(obj);
            AppMethodBeat.m2505o(110825);
        }
        z = true;
        this.czr = z;
        str = this.gpx;
        if (str == null) {
        }
        setDataInternal(obj);
        AppMethodBeat.m2505o(110825);
    }

    private final void setDataInternal(Object obj) {
        int i;
        AppMethodBeat.m2504i(110826);
        C39875f c39875f = C39875f.rZu;
        this.sps = C39875f.m68280a(obj, this.spC, this.soE, this.gpx, this.rZI);
        C39876h c39876h = this.sps;
        if (c39876h != null) {
            c39876h.mo37742ET(this.rZE);
        }
        C4990ab.m7416i(TAG, "presenter " + this.sps + " galleryType " + this.soE);
        c39876h = this.sps;
        if (c39876h != null) {
            c39876h.czC();
        }
        this.spx.setVisibility(0);
        switch (C35262m.eQZ[this.soE.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
                i = 1;
                break;
            default:
                i = 0;
                break;
        }
        if (i == 0) {
            GalleryVerticalControlView galleryVerticalControlView = this.spx;
            galleryVerticalControlView.sif.setVisibility(0);
            galleryVerticalControlView.soC.setVisibility(8);
        } else if (obj instanceof C39864o) {
            this.spx.setUserList(C43638e.m78106a((C39864o) obj));
        } else if (obj instanceof List) {
            this.spx.setUserList((List) obj);
        }
        if (this.soE == C29273a.SelfTabGallery && (getLayoutParams() instanceof MarginLayoutParams)) {
            GalleryHolderView galleryHolderView = this.spz;
            LayoutParams layoutParams = getLayoutParams();
            if (layoutParams == null) {
                C44941v c44941v = new C44941v("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                AppMethodBeat.m2505o(110826);
                throw c44941v;
            }
            galleryHolderView.setInitMargin(((MarginLayoutParams) layoutParams).topMargin);
        }
        AppMethodBeat.m2505o(110826);
    }

    /* renamed from: a */
    public final void mo55934a(PullDownListView pullDownListView) {
        AppMethodBeat.m2504i(110827);
        this.spf = pullDownListView;
        this.spw = new C36821c();
        C36821c c36821c = this.spw;
        if (c36821c != null) {
            c36821c.snE = this;
        }
        C36821c c36821c2 = this.spw;
        if (c36821c2 != null) {
            c36821c2.snD = pullDownListView;
        }
        c36821c2 = this.spw;
        if (c36821c2 != null) {
            this.shf.mo9092a((C35248e) c36821c2);
            AppMethodBeat.m2505o(110827);
            return;
        }
        AppMethodBeat.m2505o(110827);
    }

    public final void onResume() {
        AppMethodBeat.m2504i(110828);
        C4990ab.m7416i(TAG, "LogStory: onResume " + hashCode() + ", galleryType:" + this.soE + " videoViewMgr " + this.soY);
        this.dirty = true;
        cCK();
        C39876h c39876h = this.sps;
        if (c39876h != null) {
            c39876h.resume();
        }
        C22319p c22319p = this.soY;
        if (c22319p != null) {
            c22319p.akW();
        }
        StoryGalleryItemView storyGalleryItemView = this.sph;
        if (!(storyGalleryItemView == null || storyGalleryItemView.getCommentView() == null)) {
            StoryCommentView.resume();
        }
        C35180c c35180c = C35180c.sbQ;
        C35180c.czR();
        C4116b c4116b = C4116b.sbw;
        C4116b.czR();
        if (this.spt) {
            storyGalleryItemView = this.sph;
            if (storyGalleryItemView != null) {
                storyGalleryItemView.cCI();
                AppMethodBeat.m2505o(110828);
                return;
            }
        }
        AppMethodBeat.m2505o(110828);
    }

    public final void onStart() {
        AppMethodBeat.m2504i(110829);
        C4990ab.m7416i(TAG, "LogStory, onStart " + hashCode() + " galleryType:" + this.soE);
        AppMethodBeat.m2505o(110829);
    }

    public final void onPause() {
        AppMethodBeat.m2504i(110830);
        C4990ab.m7416i(TAG, "LogStory: onPause " + hashCode() + " galleryType:" + this.soE + " videoViewMgr " + this.soY);
        this.dirty = true;
        C39876h c39876h = this.sps;
        if (c39876h != null) {
            c39876h.pause();
        }
        C22319p c22319p = this.soY;
        if (c22319p != null) {
            c22319p.akV();
        }
        StoryGalleryItemView storyGalleryItemView = this.sph;
        if (!(storyGalleryItemView == null || storyGalleryItemView.getCommentView() == null)) {
            StoryCommentView.pause();
        }
        C29366a c29366a = this.spy;
        if (c29366a != null) {
            c29366a.dismiss();
        }
        C22212h c22212h = C22212h.scu;
        C22212h.m33888EX(11);
        C46279b c46279b = C46279b.rVw;
        C46279b.cyZ();
        reset();
        AppMethodBeat.m2505o(110830);
    }

    public final void onStop() {
        AppMethodBeat.m2504i(110831);
        C4990ab.m7416i(TAG, "LogStory, onStop:" + hashCode());
        AppMethodBeat.m2505o(110831);
    }

    public final void onDestroy() {
        AppMethodBeat.m2504i(110832);
        C4990ab.m7416i(TAG, "LogStory, onDestroy " + hashCode() + " galleryType:" + this.soE + " videoViewMgr " + this.soY);
        C29304c c29304c = C29304c.rSd;
        C29304c.m46524b(this);
        m57880db();
        C39876h c39876h = this.sps;
        if (c39876h != null) {
            c39876h.destroy();
        }
        C22210l c22210l = C22210l.sac;
        C22210l.czJ();
        StoryGalleryItemView storyGalleryItemView = this.sph;
        if (storyGalleryItemView != null) {
            StoryCommentView commentView = storyGalleryItemView.getCommentView();
            if (commentView != null) {
                commentView.destroy();
            }
        }
        C22319p c22319p = this.soY;
        if (c22319p != null) {
            c22319p.aEX();
        }
        C39933n c39933n = C39933n.sqi;
        C39933n.cCO();
        C4133a c4133a = C43644j.rST;
        C4133a.cya().rXL = null;
        c39933n = C39933n.sqi;
        int cCR = C39933n.cCR();
        C4990ab.m7416i(TAG, "onDestroy speed " + cCR + ' ');
        C4116b c4116b = C4116b.sbw;
        C4116b.m6435EW(cCR);
        this.spA.destroy();
        AppMethodBeat.m2505o(110832);
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0036  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: wY */
    public final boolean mo55964wY() {
        boolean Ab;
        C35171g c35171g;
        boolean z = false;
        AppMethodBeat.m2504i(110833);
        C22212h c22212h = C22212h.scu;
        C22212h.m33888EX(10);
        StoryGalleryItemView storyGalleryItemView = this.sph;
        if (storyGalleryItemView != null) {
            StoryCommentView commentView = storyGalleryItemView.getCommentView();
            if (commentView != null) {
                Ab = commentView.mo74429Ab();
                C4990ab.m7410d(TAG, "onBackPressed commentView result:".concat(String.valueOf(Ab)));
                if (!Ab && this.spt) {
                    c35171g = this.spu;
                    if (c35171g != null) {
                        c35171g.caC();
                    }
                    if (Ab || this.spt) {
                        z = true;
                    }
                    Ab = z;
                }
                C4990ab.m7410d(TAG, "onBackPressed result:".concat(String.valueOf(Ab)));
                AppMethodBeat.m2505o(110833);
                return Ab;
            }
        }
        Ab = false;
        C4990ab.m7410d(TAG, "onBackPressed commentView result:".concat(String.valueOf(Ab)));
        c35171g = this.spu;
        if (c35171g != null) {
        }
        z = true;
        Ab = z;
        C4990ab.m7410d(TAG, "onBackPressed result:".concat(String.valueOf(Ab)));
        AppMethodBeat.m2505o(110833);
        return Ab;
    }

    /* JADX WARNING: Removed duplicated region for block: B:65:0x0169  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x01b2  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x018d  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x019c  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x01b2  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x01f9  */
    /* JADX WARNING: Removed duplicated region for block: B:100:0x0227  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x014e  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x017f  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x018d  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x019c  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x01b2  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x01f9  */
    /* JADX WARNING: Removed duplicated region for block: B:100:0x0227  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: K */
    public final void mo55932K(boolean z, boolean z2) {
        C5127a c5127a;
        String str = null;
        AppMethodBeat.m2504i(110834);
        C4990ab.m7416i(TAG, "LogStory: onSwitchVideoMode isMute:" + z + " videoViewMgr " + this.soY + " videoViewMgrFromPreLoad " + this.spd);
        this.spq.setActive(true);
        this.spt = true;
        this.eif = z;
        StoryGalleryItemView storyGalleryItemView = this.sph;
        if (storyGalleryItemView != null) {
            storyGalleryItemView.setMute(z);
        }
        if (this.spr.size() > 0 && this.rZb >= 0 && this.rZb < this.spr.size() && this.spn < ((ArrayList) this.spr.get(this.rZb)).size() && this.spn >= 0) {
            C4990ab.m7416i(TAG, "help LogStory: onItemSelected " + this.spt);
            C35201i c35201i = ((C43640g) ((ArrayList) this.spr.get(this.rZb)).get(this.spn)).rVZ;
            C39933n c39933n = C39933n.sqi;
            C39933n.m68382e(this.spr, this.rZb, this.spn);
            C39933n.sqi.mo63130f(c35201i);
        }
        storyGalleryItemView = this.sph;
        if (storyGalleryItemView != null) {
            storyGalleryItemView.cCI();
        }
        C22319p c22319p;
        if (this.spd) {
            c22319p = this.soY;
            if (c22319p != null) {
                c22319p.cDf();
            }
        } else {
            c22319p = this.soY;
            if (c22319p != null) {
                c22319p.cDe();
            }
        }
        setEnabled(true);
        C39876h c39876h = this.sps;
        if (c39876h != null) {
            c39876h.mo37740EO(1);
        }
        if (!(this.soE == C29273a.HistoryGallery || this.soE == C29273a.MultiUserGallery || this.soE == C29273a.FavSelfStoryGallery || this.soE == C29273a.FavOtherStoryGallery)) {
            mo55931Fk(1);
        }
        if (this.soE == C29273a.SelfTabGallery && this.spz.getVisibility() == 0) {
            this.spz.cCF();
        }
        if (this.soE == C29273a.SelfTabGallery) {
            c5127a = C5127a.USERINFO_STORY_PULL_DOWN_MORE_TAB_FIRST_BOOLEAN_SYNC;
        } else if (this.soE == C29273a.ProfileGallery) {
            c5127a = C5127a.USERINFO_STORY_PULL_DOWN_PROFILE_FIRST_BOOLEAN_SYNC;
        } else {
            c5127a = null;
        }
        C1706e RP = C1720g.m3536RP();
        C25052j.m39375o(RP, "storage()");
        RP.mo5239Ry().set(c5127a, Boolean.TRUE);
        this.spg.setVisibility(8);
        if (z2) {
            String str2;
            Object valueOf;
            C22212h c22212h = C22212h.scu;
            C22212h.cAv();
            c22212h = C22212h.scu;
            storyGalleryItemView = this.sph;
            if (storyGalleryItemView != null) {
                C35201i videoItem = storyGalleryItemView.getVideoItem();
                if (videoItem != null) {
                    str2 = videoItem.username;
                    if (!C22212h.aaP(str2)) {
                        c22212h = C22212h.scu;
                        C22212h.cAs().mo20747bK(1);
                        storyGalleryItemView = this.sph;
                        if (storyGalleryItemView != null) {
                            videoItem = storyGalleryItemView.getVideoItem();
                            if (videoItem != null) {
                                str2 = videoItem.username;
                                if (C1855t.m3912mY(str2)) {
                                    c22212h = C22212h.scu;
                                    C22212h.cAs().mo20748bL(1);
                                }
                            }
                        }
                        str2 = null;
                        if (C1855t.m3912mY(str2)) {
                        }
                    }
                    c22212h = C22212h.scu;
                    C22212h.cAs().mo20751bO(1);
                    storyGalleryItemView = this.sph;
                    if (storyGalleryItemView != null) {
                        videoItem = storyGalleryItemView.getVideoItem();
                        if (videoItem != null) {
                            str2 = videoItem.username;
                            if (C1855t.m3912mY(str2)) {
                                c22212h = C22212h.scu;
                                C22212h.cAs().mo20752bP(1);
                            }
                            c22212h = C22212h.scu;
                            storyGalleryItemView = this.sph;
                            if (storyGalleryItemView != null) {
                                videoItem = storyGalleryItemView.getVideoItem();
                                if (videoItem != null) {
                                    valueOf = Long.valueOf(videoItem.rUJ);
                                    if (!C22212h.aaQ(String.valueOf(valueOf))) {
                                        c22212h = C22212h.scu;
                                        C22212h.cAs().mo20749bM(1);
                                        storyGalleryItemView = this.sph;
                                        if (storyGalleryItemView != null) {
                                            videoItem = storyGalleryItemView.getVideoItem();
                                            if (videoItem != null) {
                                                str = videoItem.username;
                                            }
                                        }
                                        if (C1855t.m3912mY(str)) {
                                            c22212h = C22212h.scu;
                                            C22212h.cAs().mo20750bN(1);
                                        }
                                    }
                                    c22212h = C22212h.scu;
                                    C22212h.cAs().mo20753bQ(1);
                                    c22212h = C22212h.scu;
                                    C22212h.cAs().mo20745bI(System.currentTimeMillis());
                                    c22212h = C22212h.scu;
                                    C22212h.cAl();
                                    if (this.spr.size() != 1 && ((ArrayList) this.spr.get(0)).size() == 0) {
                                        c22212h = C22212h.scu;
                                        C22212h.cAu();
                                        AppMethodBeat.m2505o(110834);
                                        return;
                                    } else if (this.spr.size() > this.rZb || this.rZb < 0 || this.spn < 0 || ((ArrayList) this.spr.get(this.rZb)).size() <= this.spn) {
                                        c22212h = C22212h.scu;
                                        C22212h.cAu();
                                        AppMethodBeat.m2505o(110834);
                                        return;
                                    } else {
                                        cCL();
                                        m57890lL(true);
                                        c22212h = C22212h.scu;
                                        C9504au cAG = C22212h.cAG();
                                        C22212h c22212h2 = C22212h.scu;
                                        cAG.mo20771cg(C22212h.cAs().mo20734FH());
                                        c22212h = C22212h.scu;
                                        cAG = C22212h.cAG();
                                        c22212h2 = C22212h.scu;
                                        cAG.mo20769ce(C22212h.cAs().mo20732FF());
                                        c22212h = C22212h.scu;
                                        cAG = C22212h.cAG();
                                        c22212h2 = C22212h.scu;
                                        cAG.mo20770cf(C22212h.cAs().mo20733FG());
                                        c22212h = C22212h.scu;
                                        C22212h.cAG().mo20772fF(((C43640g) ((ArrayList) this.spr.get(this.rZb)).get(this.spn)).userName);
                                        c22212h = C22212h.scu;
                                        C22212h.cAG().mo20773fG(String.valueOf(((C43640g) ((ArrayList) this.spr.get(this.rZb)).get(this.spn)).rUJ));
                                        c22212h = C22212h.scu;
                                        C22212h.cAH();
                                        AppMethodBeat.m2505o(110834);
                                        return;
                                    }
                                }
                            }
                            valueOf = null;
                            if (C22212h.aaQ(String.valueOf(valueOf))) {
                            }
                            c22212h = C22212h.scu;
                            C22212h.cAs().mo20753bQ(1);
                            c22212h = C22212h.scu;
                            C22212h.cAs().mo20745bI(System.currentTimeMillis());
                            c22212h = C22212h.scu;
                            C22212h.cAl();
                            if (this.spr.size() != 1) {
                            }
                            if (this.spr.size() > this.rZb) {
                            }
                            c22212h = C22212h.scu;
                            C22212h.cAu();
                            AppMethodBeat.m2505o(110834);
                            return;
                        }
                    }
                    str2 = null;
                    if (C1855t.m3912mY(str2)) {
                    }
                    c22212h = C22212h.scu;
                    storyGalleryItemView = this.sph;
                    if (storyGalleryItemView != null) {
                    }
                    valueOf = null;
                    if (C22212h.aaQ(String.valueOf(valueOf))) {
                    }
                    c22212h = C22212h.scu;
                    C22212h.cAs().mo20753bQ(1);
                    c22212h = C22212h.scu;
                    C22212h.cAs().mo20745bI(System.currentTimeMillis());
                    c22212h = C22212h.scu;
                    C22212h.cAl();
                    if (this.spr.size() != 1) {
                    }
                    if (this.spr.size() > this.rZb) {
                    }
                    c22212h = C22212h.scu;
                    C22212h.cAu();
                    AppMethodBeat.m2505o(110834);
                    return;
                }
            }
            str2 = null;
            if (C22212h.aaP(str2)) {
            }
            c22212h = C22212h.scu;
            C22212h.cAs().mo20751bO(1);
            storyGalleryItemView = this.sph;
            if (storyGalleryItemView != null) {
            }
            str2 = null;
            if (C1855t.m3912mY(str2)) {
            }
            c22212h = C22212h.scu;
            storyGalleryItemView = this.sph;
            if (storyGalleryItemView != null) {
            }
            valueOf = null;
            if (C22212h.aaQ(String.valueOf(valueOf))) {
            }
            c22212h = C22212h.scu;
            C22212h.cAs().mo20753bQ(1);
            c22212h = C22212h.scu;
            C22212h.cAs().mo20745bI(System.currentTimeMillis());
            c22212h = C22212h.scu;
            C22212h.cAl();
            if (this.spr.size() != 1) {
            }
            if (this.spr.size() > this.rZb) {
            }
            c22212h = C22212h.scu;
            C22212h.cAu();
            AppMethodBeat.m2505o(110834);
            return;
        }
        AppMethodBeat.m2505o(110834);
    }

    /* renamed from: lr */
    public final void mo55945lr(boolean z) {
        C39876h c39876h;
        AppMethodBeat.m2504i(110835);
        C4990ab.m7416i(TAG, "LogStory: onSwitchImageMode videoViewMgr " + this.soY);
        this.spq.setActive(false);
        this.spt = false;
        C4141a c4141a = C4140c.saU;
        C4141a.czN().czM();
        if (this.spF && this.czr) {
            c39876h = this.sps;
            if (c39876h != null) {
                c39876h.czC();
            }
        }
        StoryGalleryItemView storyGalleryItemView = this.sph;
        if (storyGalleryItemView != null) {
            storyGalleryItemView.sfS.mo74436oE(2);
            storyGalleryItemView.sfS.hide();
        }
        C22319p c22319p = this.soY;
        if (c22319p != null) {
            c22319p.mo37854N(true, z);
        }
        setEnabled(false);
        c39876h = this.sps;
        if (c39876h != null) {
            c39876h.mo37740EO(0);
        }
        if (this.soE == C29273a.SelfTabGallery && this.spz.getVisibility() == 0) {
            GalleryHolderView galleryHolderView = this.spz;
            galleryHolderView.snI.setVisibility(4);
            galleryHolderView.iDT.setVisibility(0);
        }
        m57890lL(false);
        AppMethodBeat.m2505o(110835);
    }

    public final void cwK() {
        AppMethodBeat.m2504i(110836);
        cCJ();
        if (this.soE == C29273a.SelfTabGallery && this.spz.getVisibility() == 0) {
            this.spz.cCE();
        }
        C39876h c39876h = this.sps;
        if (c39876h != null) {
            c39876h.czE();
            AppMethodBeat.m2505o(110836);
            return;
        }
        AppMethodBeat.m2505o(110836);
    }

    public final void cwL() {
        AppMethodBeat.m2504i(110837);
        if (this.spr.size() == 1 && ((ArrayList) this.spr.get(0)).isEmpty()) {
            cCJ();
        } else {
            C4990ab.m7410d(TAG, "fadeInMaskView");
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.iVh, "alpha", new float[]{0.0f, 1.0f});
            ofFloat.addListener(new C13885e(this));
            ofFloat.start();
        }
        if (this.soE == C29273a.SelfTabGallery && this.spz.getVisibility() == 0) {
            GalleryHolderView galleryHolderView = this.spz;
            AnimatorSet animatorSet = new AnimatorSet();
            r3 = new Animator[2];
            r3[0] = ObjectAnimator.ofFloat(galleryHolderView.iDT, "alpha", new float[]{galleryHolderView.iDT.getAlpha(), galleryHolderView.snN});
            r3[1] = ObjectAnimator.ofFloat(galleryHolderView.snI, "alpha", new float[]{galleryHolderView.snI.getAlpha(), 0.0f});
            animatorSet.playTogether(r3);
            animatorSet.setDuration(100);
            animatorSet.start();
        }
        AppMethodBeat.m2505o(110837);
    }

    public final void setStoryBrowseUIListener(C35171g c35171g) {
        if (c35171g != null) {
            this.spu = c35171g;
        }
    }

    public final void setCurrentVItem(int i) {
        AppMethodBeat.m2504i(110838);
        if (i < this.spr.size()) {
            C4990ab.m7410d(TAG, "setCurrentVItem " + i + ", all:" + this.spr.size());
            GalleryRecyclerView galleryRecyclerView = this.spq;
            if (galleryRecyclerView != null) {
                galleryRecyclerView.post(new C35250o(this, i));
                AppMethodBeat.m2505o(110838);
                return;
            }
        }
        AppMethodBeat.m2505o(110838);
    }

    public final void setCurrentHItem(int i) {
        AppMethodBeat.m2504i(110839);
        if (this.rZb != -1 && this.rZb < this.spr.size() && i < ((ArrayList) this.spr.get(this.rZb)).size()) {
            RecyclerView recyclerView = this.spi;
            if (recyclerView != null) {
                recyclerView.post(new C4191n(this, i));
                AppMethodBeat.m2505o(110839);
                return;
            }
        }
        AppMethodBeat.m2505o(110839);
    }

    /* renamed from: Pb */
    public final void mo55933Pb() {
        AppMethodBeat.m2504i(110840);
        C39876h c39876h = this.sps;
        if (c39876h != null) {
            c39876h.czC();
        }
        reset();
        AppMethodBeat.m2505o(110840);
    }

    private void reset() {
        AppMethodBeat.m2504i(110841);
        C4990ab.m7416i(TAG, "reset " + C5046bo.dpG() + " isFirstPost : " + this.spG);
        if (this.spG && this.spt) {
            mo55945lr(false);
        }
        if (this.spG) {
            C1706e RP = C1720g.m3536RP();
            C25052j.m39375o(RP, "MMKernel.storage()");
            RP.mo5239Ry().set(C5127a.USERINFO_STORY_POST_FIRST_TO_AUTOPLAY_BOOLEAN_SYNC, Boolean.FALSE);
            this.spG = false;
        }
        AppMethodBeat.m2505o(110841);
    }

    /* renamed from: EF */
    public final void mo55929EF(int i) {
        AppMethodBeat.m2504i(110842);
        C4990ab.m7410d(TAG, "onOpening ".concat(String.valueOf(i)));
        if (this.soE == C29273a.SelfTabGallery && this.spz.getVisibility() == 0) {
            GalleryHolderView galleryHolderView = this.spz;
            float min = Math.min(((float) Math.abs(i)) / ((float) Math.abs(galleryHolderView.snM)), 1.0f);
            float f = 1.0f - min;
            galleryHolderView.snI.setAlpha(min);
            galleryHolderView.iDT.setAlpha(f);
            galleryHolderView.snI.setVisibility(0);
        }
        AppMethodBeat.m2505o(110842);
    }

    /* renamed from: EG */
    public final void mo55930EG(int i) {
        AppMethodBeat.m2504i(110843);
        C4990ab.m7410d(TAG, "onClosing ".concat(String.valueOf(i)));
        if (this.soE == C29273a.SelfTabGallery && this.spz.getVisibility() == 0) {
            GalleryHolderView galleryHolderView = this.spz;
            float min = Math.min(1.0f, ((float) Math.abs(i)) / ((float) Math.abs(galleryHolderView.snM)));
            galleryHolderView.snI.setAlpha(1.0f - min);
            galleryHolderView.iDT.setAlpha(min);
            galleryHolderView.snI.setVisibility(0);
        }
        AppMethodBeat.m2505o(110843);
    }

    /* renamed from: AW */
    public final void mo55928AW(int i) {
        AppMethodBeat.m2504i(110844);
        C4990ab.m7410d(TAG, "onListInnerScroll ".concat(String.valueOf(i)));
        if (this.soE == C29273a.SelfTabGallery && this.spz.getVisibility() == 0) {
            GalleryHolderView galleryHolderView = this.spz;
            float min = 1.0f - Math.min(((float) Math.abs(i)) / ((float) C1338a.fromDPToPix(galleryHolderView.getContext(), 16)), 1.0f);
            C4990ab.m7410d(GalleryHolderView.TAG, "onListInnerScroll " + i + ' ' + min);
            galleryHolderView.iDT.setAlpha(min);
            galleryHolderView.snN = min;
        }
        AppMethodBeat.m2505o(110844);
    }

    public final void setCanDragScale(boolean z) {
        this.spv = z;
    }

    private final void cCK() {
        AppMethodBeat.m2504i(110845);
        if (this.czr) {
            C4133a c4133a = C43644j.rST;
            C4133a.cya().mo15483a((C22174j) this.spH);
            c4133a = C43644j.rST;
            C4133a.cya().mo15487e(new C31574c(this));
        }
        AppMethodBeat.m2505o(110845);
    }

    /* renamed from: db */
    private final void m57880db() {
        AppMethodBeat.m2504i(110846);
        if (this.czr) {
            C4990ab.m7416i(TAG, "removeListeners");
            C4133a c4133a = C43644j.rST;
            C4133a.cya().mo15484b(this.spH);
        }
        AppMethodBeat.m2505o(110846);
    }

    private final void cCL() {
        AppMethodBeat.m2504i(110847);
        String str = TAG;
        StringBuilder stringBuilder = new StringBuilder("addVideoReadNumber ");
        StoryGalleryItemView storyGalleryItemView = this.sph;
        if (storyGalleryItemView == null) {
            C25052j.dWJ();
        }
        C35201i videoItem = storyGalleryItemView.getVideoItem();
        if (videoItem == null) {
            C25052j.dWJ();
        }
        C4990ab.m7410d(str, stringBuilder.append(videoItem.rUJ).append("  time:").append(System.currentTimeMillis()).toString());
        C5004al.m7439af(this.spI);
        C5004al.m7442n(this.spI, 500);
        AppMethodBeat.m2505o(110847);
    }

    /* renamed from: lL */
    private final void m57890lL(boolean z) {
        AppMethodBeat.m2504i(138952);
        C4990ab.m7416i(TAG, "toggleActiveState ".concat(String.valueOf(z)));
        StoryGalleryItemView storyGalleryItemView = this.sph;
        if (storyGalleryItemView != null) {
            StoryCommentView commentView = storyGalleryItemView.getCommentView();
            if (commentView != null) {
                commentView.mo74435lL(z);
            }
        }
        this.spx.mo55915lL(z);
        AppMethodBeat.m2505o(138952);
    }

    /* JADX WARNING: Removed duplicated region for block: B:98:0x01fd  */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x0324  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public static final /* synthetic */ void m57872a(C35251l c35251l, int i, View view) {
        StoryCommentView commentView;
        AppMethodBeat.m2504i(110850);
        C4990ab.m7416i(TAG, "LogStory: onItemSelected " + i + ", active:" + c35251l.spt);
        c35251l.spn = i;
        C39876h c39876h = c35251l.sps;
        if (c39876h != null) {
            c39876h.mo37747fN(c35251l.rZb, c35251l.spn);
        }
        StoryGalleryItemView storyGalleryItemView = c35251l.sph;
        if (storyGalleryItemView != null) {
            commentView = storyGalleryItemView.getCommentView();
            if (commentView != null) {
                commentView.setStateChangeCallback(null);
            }
        }
        storyGalleryItemView = c35251l.sph;
        if (storyGalleryItemView != null) {
            commentView = storyGalleryItemView.getCommentView();
            if (commentView != null) {
                commentView.hide();
            }
        }
        storyGalleryItemView = c35251l.sph;
        if (storyGalleryItemView != null) {
            ImageView thumbView = storyGalleryItemView.getThumbView();
            if (thumbView != null) {
                thumbView.setImageDrawable(null);
            }
        }
        int size = ((ArrayList) c35251l.spr.get(c35251l.rZb)).size();
        int i2 = c35251l.spn;
        if (i2 < 0) {
            AppMethodBeat.m2505o(110850);
        } else if (size <= i2) {
            AppMethodBeat.m2505o(110850);
        } else {
            String str;
            Object obj;
            C35201i c35201i = ((C43640g) ((ArrayList) c35251l.spr.get(c35251l.rZb)).get(c35251l.spn)).rVZ;
            C4133a c4133a = C43644j.rST;
            C39879j Fe = C4133a.cxT().mo74397Fe(c35201i.cNE);
            if (c35251l.spt) {
                C39933n c39933n = C39933n.sqi;
                C39933n.m68382e(c35251l.spr, c35251l.rZb, c35251l.spn);
                C39933n.sqi.mo63130f(c35201i);
            }
            C4990ab.m7416i(TAG, "LogStory: onItemSelected " + i + " selectedRow " + c35251l.rZb + " item: " + ((C43640g) ((ArrayList) c35251l.spr.get(c35251l.rZb)).get(c35251l.spn)).rVZ + " isMute " + c35251l.eif);
            c35251l.sph = (StoryGalleryItemView) view;
            storyGalleryItemView = c35251l.sph;
            if (storyGalleryItemView != null) {
                storyGalleryItemView.setVideoViewMgr(c35251l.soY);
            }
            storyGalleryItemView = c35251l.sph;
            if (storyGalleryItemView != null) {
                storyGalleryItemView.setMute(c35251l.eif);
            }
            StoryGalleryItemView storyGalleryItemView2 = c35251l.sph;
            if (storyGalleryItemView2 != null) {
                storyGalleryItemView2.rVZ = c35201i;
                if (c35201i != null) {
                    C22319p c22319p = storyGalleryItemView2.soY;
                    if (c22319p != null) {
                        c22319p.mo37855a(storyGalleryItemView2.soW, storyGalleryItemView2.soX);
                    }
                    C22319p c22319p2 = storyGalleryItemView2.soY;
                    if (c22319p2 != null) {
                        c22319p2.mo37862o(c35201i);
                    }
                    storyGalleryItemView2.soW.setVisibility(0);
                }
            }
            storyGalleryItemView = c35251l.sph;
            if (storyGalleryItemView != null) {
                C35201i c35201i2 = storyGalleryItemView.rVZ;
                if (c35201i2 != null) {
                    C44222az Mp = C44222az.dtm().mo69860Mp(c35201i2.fDG);
                    if (!c35201i2.cze()) {
                        C4133a c4133a2 = C43644j.rST;
                        C18532d cyc = C4133a.cyc();
                        cek cek = c35201i2.rWj;
                        str = c35201i2.username;
                        C25052j.m39375o(Mp, "fromScene");
                        cyc.mo33785aO(new C24833d(cek, str, Mp)).mo44153d(storyGalleryItemView.mmB);
                    } else if (c35201i2.rWl == null) {
                        C37881e c37881e = C37881e.eOD;
                        C37881e.m63942Tb().mo41564lR("").mo44153d(storyGalleryItemView.mmB);
                    } else {
                        cee cee = c35201i2.rWl;
                        if (cee != null) {
                            C4990ab.m7416i(storyGalleryItemView.TAG, "load fake localFile:" + cee.thumbPath + ", position:" + storyGalleryItemView.position + ", videoPath:" + cee.videoPath);
                            C37881e c37881e2 = C37881e.eOD;
                            C24669a Tb = C37881e.m63942Tb();
                            str = cee.thumbPath;
                            C25052j.m39375o(str, "it.thumbPath");
                            Tb.mo41564lR(str).mo44153d(storyGalleryItemView.mmB);
                        }
                    }
                }
            }
            storyGalleryItemView = c35251l.sph;
            if (storyGalleryItemView != null) {
                if (c35251l.spt) {
                    C35180c c35180c = C35180c.sbQ;
                    str = c35201i.username;
                    storyGalleryItemView.mo26089d(c35201i);
                    C35180c.m57806ar(str, c35201i.rUJ);
                    C4116b c4116b = C4116b.sbw;
                    str = c35201i.username;
                    storyGalleryItemView.mo26089d(c35201i);
                    C4116b.m6440j(str, c35201i.rUJ, c35251l.spn);
                }
                C35180c c35180c2 = C35180c.sbQ;
                C35180c.m57807b(c35251l.spr, c35251l.rZb, c35251l.spn);
                C4116b c4116b2 = C4116b.sbw;
                C4116b.m6437b(c35251l.spr, c35251l.rZb, c35251l.spn);
            }
            storyGalleryItemView = c35251l.sph;
            if (storyGalleryItemView != null) {
                StoryCommentView commentView2 = storyGalleryItemView.getCommentView();
                if (commentView2 != null) {
                    commentView2.setStateChangeCallback(new C35253i(c35251l));
                }
            }
            storyGalleryItemView = c35251l.sph;
            if (storyGalleryItemView != null) {
                commentView = storyGalleryItemView.getCommentView();
                if (commentView != null) {
                    commentView.setOutsideClickListener(c35251l.skn);
                }
            }
            if (c35251l.spt) {
                storyGalleryItemView = c35251l.sph;
                if (storyGalleryItemView != null) {
                    commentView = storyGalleryItemView.getCommentView();
                    if (commentView != null) {
                        commentView.show();
                    }
                }
            } else {
                storyGalleryItemView = c35251l.sph;
                if (storyGalleryItemView != null) {
                    commentView = storyGalleryItemView.getCommentView();
                    if (commentView != null) {
                        commentView.hide();
                    }
                }
            }
            storyGalleryItemView = c35251l.sph;
            if (storyGalleryItemView != null) {
                commentView = storyGalleryItemView.getCommentView();
                if (commentView != null) {
                    commentView.setSessionId(c35251l.cvF);
                }
            }
            GalleryHorizontalControlView galleryHorizontalControlView = c35251l.spj;
            if (galleryHorizontalControlView != null) {
                galleryHorizontalControlView.setSelection(c35251l.spn);
            }
            if (c35251l.czr) {
                if (c35251l.soE != C29273a.FavSelfStoryGallery) {
                    boolean z;
                    GalleryVerticalControlView galleryVerticalControlView;
                    if (Fe == null || !Fe.cBV() || Fe.cBX()) {
                        z = false;
                    } else {
                        z = true;
                    }
                    if (Fe != null) {
                        if (Fe.cBR().xeC == 0) {
                            obj = 1;
                        } else {
                            obj = null;
                        }
                        if (obj == null && !Fe.cBX()) {
                            obj = 1;
                            c35251l.spx.mo55916lT(z);
                            if (!z) {
                                c35251l.spx.mo55917lU(Fe == null ? false : Fe.cBW());
                            }
                            galleryVerticalControlView = c35251l.spx;
                            if (obj == null && C29274a.rQZ.cxh()) {
                                galleryVerticalControlView.soB.setVisibility(0);
                                galleryVerticalControlView.soB.setImageDrawable(C5225ah.m7962f(galleryVerticalControlView.getContext(), C1318a.icons_filled_moment_off, galleryVerticalControlView.getResources().getColor(C25738R.color.a29)));
                            } else {
                                galleryVerticalControlView.soB.setVisibility(8);
                            }
                        }
                    }
                    obj = null;
                    c35251l.spx.mo55916lT(z);
                    if (z) {
                    }
                    galleryVerticalControlView = c35251l.spx;
                    if (obj == null) {
                    }
                    galleryVerticalControlView.soB.setVisibility(8);
                }
                c35251l.spx.mo55915lL(c35251l.spt);
            }
            if (c35251l.spD == i) {
                c35251l.spE = false;
            }
            if (c35251l.spD != i && c35251l.spt) {
                C22212h c22212h;
                String str2;
                obj = ((ArrayList) c35251l.spr.get(c35251l.rZb)).get(i);
                C25052j.m39375o(obj, "galleryGroups[selectedRow][position]");
                C43640g c43640g = (C43640g) obj;
                c35251l.cCL();
                C22212h c22212h2 = C22212h.scu;
                C9502ar cAs = C22212h.cAs();
                cAs.mo20751bO(cAs.mo20739FM() + 1);
                if (C1855t.m3912mY(c35201i.username)) {
                    c22212h2 = C22212h.scu;
                    cAs = C22212h.cAs();
                    cAs.mo20752bP(cAs.mo20740FN() + 1);
                }
                c22212h2 = C22212h.scu;
                if (!C22212h.aaQ(String.valueOf(c43640g.rUJ))) {
                    c22212h = C22212h.scu;
                    C9502ar cAs2 = C22212h.cAs();
                    cAs2.mo20749bM(cAs2.mo20737FK() + 1);
                    if (C1855t.m3912mY(c35201i.username)) {
                        c22212h = C22212h.scu;
                        cAs2 = C22212h.cAs();
                        cAs2.mo20750bN(cAs2.mo20738FL() + 1);
                    }
                }
                if (!c35251l.spE) {
                    c22212h = C22212h.scu;
                    C22212h.m33888EX(3);
                }
                c35251l.spE = false;
                c22212h = C22212h.scu;
                C9504au cAG = C22212h.cAG();
                c22212h2 = C22212h.scu;
                cAG.mo20771cg(C22212h.cAs().mo20734FH());
                c22212h = C22212h.scu;
                cAG = C22212h.cAG();
                c22212h2 = C22212h.scu;
                cAG.mo20769ce(C22212h.cAs().mo20732FF());
                c22212h = C22212h.scu;
                cAG = C22212h.cAG();
                c22212h2 = C22212h.scu;
                cAG.mo20770cf(C22212h.cAs().mo20733FG());
                c22212h = C22212h.scu;
                C9504au cAG2 = C22212h.cAG();
                storyGalleryItemView = c35251l.sph;
                if (storyGalleryItemView != null) {
                    C35201i videoItem = storyGalleryItemView.getVideoItem();
                    if (videoItem != null) {
                        str2 = videoItem.username;
                        cAG2.mo20772fF(str2);
                        c22212h = C22212h.scu;
                        cAG2 = C22212h.cAG();
                        storyGalleryItemView = c35251l.sph;
                        if (storyGalleryItemView != null) {
                            videoItem = storyGalleryItemView.getVideoItem();
                            if (videoItem != null) {
                                obj = Long.valueOf(videoItem.rUJ);
                                cAG2.mo20773fG(String.valueOf(obj));
                                c22212h = C22212h.scu;
                                C22212h.cAH();
                            }
                        }
                        obj = null;
                        cAG2.mo20773fG(String.valueOf(obj));
                        c22212h = C22212h.scu;
                        C22212h.cAH();
                    }
                }
                str2 = null;
                cAG2.mo20772fF(str2);
                c22212h = C22212h.scu;
                cAG2 = C22212h.cAG();
                storyGalleryItemView = c35251l.sph;
                if (storyGalleryItemView != null) {
                }
                obj = null;
                cAG2.mo20773fG(String.valueOf(obj));
                c22212h = C22212h.scu;
                C22212h.cAH();
            }
            c35251l.spD = c35251l.spn;
            AppMethodBeat.m2505o(110850);
        }
    }

    /* renamed from: a */
    public static final /* synthetic */ void m57871a(C35251l c35251l, int i, RecyclerView recyclerView, GalleryHorizontalControlView galleryHorizontalControlView) {
        AppMethodBeat.m2504i(110852);
        C4990ab.m7416i(TAG, "LogStory: onRowSelected " + i + ", " + recyclerView);
        if (!(c35251l.rZb == i && C25052j.m39373j(c35251l.spi, recyclerView))) {
            Object obj;
            C17480i layoutManager;
            C41523a adapter;
            C22212h c22212h;
            c35251l.spE = c35251l.spt;
            c35251l.spD = -1;
            c35251l.rZb = i;
            RecyclerView recyclerView2 = c35251l.spi;
            C22262b c22262b = (C22262b) (recyclerView2 != null ? recyclerView2.getLayoutManager() : null);
            if (c22262b != null) {
                c22262b.lqs = null;
            }
            c35251l.spi = recyclerView;
            c35251l.spj = galleryHorizontalControlView;
            int size = c35251l.spr.size();
            int i2 = c35251l.rZb;
            if (i2 >= 0 && size > i2) {
                GalleryHorizontalControlView galleryHorizontalControlView2 = c35251l.spj;
                if (galleryHorizontalControlView2 != null) {
                    obj = c35251l.spr.get(c35251l.rZb);
                    C25052j.m39375o(obj, "galleryGroups[selectedRow]");
                    galleryHorizontalControlView2.mo55908dI((List) obj);
                }
            }
            recyclerView2 = c35251l.spi;
            if (recyclerView2 != null) {
                layoutManager = recyclerView2.getLayoutManager();
            } else {
                layoutManager = null;
            }
            c22262b = (C22262b) layoutManager;
            if (c22262b != null) {
                c22262b.lqs = new C35261j(c35251l);
            }
            if (c22262b != null) {
                c22262b.mo37786gK(true);
            }
            c35251l.spl.mo42393i(recyclerView);
            recyclerView2 = c35251l.spi;
            if (recyclerView2 != null) {
                adapter = recyclerView2.getAdapter();
            } else {
                adapter = null;
            }
            c35251l.spk = (C29324g) adapter;
            if (!((ArrayList) c35251l.spr.get(i)).isEmpty()) {
                obj = ((ArrayList) c35251l.spr.get(i)).get(0);
                C25052j.m39375o(obj, "galleryGroups[row][0]");
                C43640g c43640g = (C43640g) obj;
                C22212h c22212h2 = C22212h.scu;
                if (!C22212h.aaP(c43640g.userName)) {
                    c22212h2 = C22212h.scu;
                    C9502ar cAs = C22212h.cAs();
                    cAs.mo20747bK(cAs.mo20735FI() + 1);
                    if (C1855t.m3912mY(c43640g.userName)) {
                        c22212h = C22212h.scu;
                        C9502ar cAs2 = C22212h.cAs();
                        cAs2.mo20748bL(cAs2.mo20736FJ() + 1);
                    }
                }
            }
            c22212h = C22212h.scu;
            C22212h.m33888EX(4);
        }
        AppMethodBeat.m2505o(110852);
    }

    /* renamed from: s */
    public static final /* synthetic */ void m57897s(C35251l c35251l) {
        String string;
        AppMethodBeat.m2504i(110853);
        Object obj = ((ArrayList) c35251l.spr.get(c35251l.rZb)).get(c35251l.spn);
        C25052j.m39375o(obj, "galleryGroups[selectedRow][selectedColumn]");
        C43640g c43640g = (C43640g) obj;
        C4133a c4133a = C43644j.rST;
        C39879j Fe = C4133a.cxT().mo74397Fe(c43640g.rVZ.cNE);
        if (Fe == null || !Fe.cBW()) {
            string = c35251l.getContext().getString(C25738R.string.esh);
        } else {
            string = c35251l.getContext().getString(C25738R.string.g_g);
        }
        C5659a c5659a = new C5659a(c35251l.getContext());
        c5659a.asL(string).asP(c35251l.getContext().getString(C25738R.string.esh)).mo11510Qh(-65536).mo11526re(true);
        c5659a.mo11523c(new C35260h(c35251l, Fe)).show();
        C4990ab.m7416i(TAG, "delete click");
        AppMethodBeat.m2505o(110853);
    }

    /* renamed from: t */
    public static final /* synthetic */ void m57898t(C35251l c35251l) {
        boolean z;
        boolean z2 = false;
        AppMethodBeat.m2504i(110855);
        C29366a c29366a = c35251l.spy;
        if (c29366a != null) {
            z = c29366a.rvv;
        } else {
            z = false;
        }
        if (!z) {
            C1706e RP = C1720g.m3536RP();
            C25052j.m39375o(RP, "MMKernel.storage()");
            if (RP.mo5239Ry().getBoolean(C5127a.USERINFO_STORY_EDITOR_SHOW_PRIVACY_TIP_BOOLEAN_SYNC, true)) {
                C1706e RP2 = C1720g.m3536RP();
                C25052j.m39375o(RP2, "MMKernel.storage()");
                RP2.mo5239Ry().set(C5127a.USERINFO_STORY_EDITOR_SHOW_PRIVACY_TIP_BOOLEAN_SYNC, Boolean.FALSE);
                C30379h.m48438a(c35251l.getContext(), "", c35251l.getContext().getString(C25738R.string.g_k), (OnClickListener) new C13890l(c35251l));
                AppMethodBeat.m2505o(110855);
                return;
            }
        }
        C39876h c39876h = c35251l.sps;
        if (c39876h != null) {
            int i = c35251l.rZb;
            int i2 = c35251l.spn;
            C29366a c29366a2 = c35251l.spy;
            if (c29366a2 != null) {
                z2 = c29366a2.rvv;
            }
            c39876h.mo37753n(i, i2, z2);
            AppMethodBeat.m2505o(110855);
            return;
        }
        AppMethodBeat.m2505o(110855);
    }

    /* renamed from: u */
    public static final /* synthetic */ void m57899u(C35251l c35251l) {
        boolean z;
        boolean z2 = false;
        AppMethodBeat.m2504i(110856);
        C29366a c29366a = c35251l.spy;
        if (c29366a != null) {
            z = c29366a.rYr;
        } else {
            z = false;
        }
        if (!z) {
            C1706e RP = C1720g.m3536RP();
            C25052j.m39375o(RP, "MMKernel.storage()");
            if (RP.mo5239Ry().getBoolean(C5127a.USERINFO_STORY_EDITOR_SHOW_FAV_TIP_BOOLEAN_SYNC, true)) {
                C1706e RP2 = C1720g.m3536RP();
                C25052j.m39375o(RP2, "MMKernel.storage()");
                RP2.mo5239Ry().set(C5127a.USERINFO_STORY_EDITOR_SHOW_FAV_TIP_BOOLEAN_SYNC, Boolean.FALSE);
                Context context = c35251l.getContext();
                C25052j.m39375o(context, "context");
                C30379h.m48438a(c35251l.getContext(), "", context.getResources().getString(C25738R.string.g_j), (OnClickListener) new C13889k(c35251l));
                AppMethodBeat.m2505o(110856);
                return;
            }
        }
        C39876h c39876h = c35251l.sps;
        if (c39876h != null) {
            int i = c35251l.rZb;
            int i2 = c35251l.spn;
            C29366a c29366a2 = c35251l.spy;
            if (c29366a2 != null) {
                z2 = c29366a2.rYr;
            }
            c39876h.mo37754o(i, i2, z2);
            AppMethodBeat.m2505o(110856);
            return;
        }
        AppMethodBeat.m2505o(110856);
    }
}
