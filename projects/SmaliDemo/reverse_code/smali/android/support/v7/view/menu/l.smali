.class public Landroid/support/v7/view/menu/l;
.super Ljava/lang/Object;
.source ""

# interfaces
.implements La/b/c/c/a/a;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/support/v7/view/menu/l$b;,
        Landroid/support/v7/view/menu/l$a;
    }
.end annotation


# static fields
.field private static final a:[I


# instance fields
.field private A:Z

.field private final b:Landroid/content/Context;

.field private final c:Landroid/content/res/Resources;

.field private d:Z

.field private e:Z

.field private f:Landroid/support/v7/view/menu/l$a;

.field private g:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList<",
            "Landroid/support/v7/view/menu/p;",
            ">;"
        }
    .end annotation
.end field

.field private h:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList<",
            "Landroid/support/v7/view/menu/p;",
            ">;"
        }
    .end annotation
.end field

.field private i:Z

.field private j:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList<",
            "Landroid/support/v7/view/menu/p;",
            ">;"
        }
    .end annotation
.end field

.field private k:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList<",
            "Landroid/support/v7/view/menu/p;",
            ">;"
        }
    .end annotation
.end field

.field private l:Z

.field private m:I

.field private n:Landroid/view/ContextMenu$ContextMenuInfo;

.field o:Ljava/lang/CharSequence;

.field p:Landroid/graphics/drawable/Drawable;

.field q:Landroid/view/View;

.field private r:Z

.field private s:Z

.field private t:Z

.field private u:Z

.field private v:Z

.field private w:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList<",
            "Landroid/support/v7/view/menu/p;",
            ">;"
        }
    .end annotation
.end field

.field private x:Ljava/util/concurrent/CopyOnWriteArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/concurrent/CopyOnWriteArrayList<",
            "Ljava/lang/ref/WeakReference<",
            "Landroid/support/v7/view/menu/v;",
            ">;>;"
        }
    .end annotation
.end field

.field private y:Landroid/support/v7/view/menu/p;

.field private z:Z


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .line 68
    const/4 v0, 0x6

    new-array v0, v0, [I

    fill-array-data v0, :array_0

    sput-object v0, Landroid/support/v7/view/menu/l;->a:[I

    return-void

    nop

    :array_0
    .array-data 4
        0x1
        0x4
        0x5
        0x3
        0x2
        0x0
    .end array-data
.end method

.method public constructor <init>(Landroid/content/Context;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;

    .line 229
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 134
    const/4 v0, 0x0

    iput v0, p0, Landroid/support/v7/view/menu/l;->m:I

    .line 165
    iput-boolean v0, p0, Landroid/support/v7/view/menu/l;->r:Z

    .line 167
    iput-boolean v0, p0, Landroid/support/v7/view/menu/l;->s:Z

    .line 169
    iput-boolean v0, p0, Landroid/support/v7/view/menu/l;->t:Z

    .line 171
    iput-boolean v0, p0, Landroid/support/v7/view/menu/l;->u:Z

    .line 173
    iput-boolean v0, p0, Landroid/support/v7/view/menu/l;->v:Z

    .line 175
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    iput-object v1, p0, Landroid/support/v7/view/menu/l;->w:Ljava/util/ArrayList;

    .line 177
    new-instance v1, Ljava/util/concurrent/CopyOnWriteArrayList;

    invoke-direct {v1}, Ljava/util/concurrent/CopyOnWriteArrayList;-><init>()V

    iput-object v1, p0, Landroid/support/v7/view/menu/l;->x:Ljava/util/concurrent/CopyOnWriteArrayList;

    .line 188
    iput-boolean v0, p0, Landroid/support/v7/view/menu/l;->z:Z

    .line 230
    iput-object p1, p0, Landroid/support/v7/view/menu/l;->b:Landroid/content/Context;

    .line 231
    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    iput-object v0, p0, Landroid/support/v7/view/menu/l;->c:Landroid/content/res/Resources;

    .line 232
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Landroid/support/v7/view/menu/l;->g:Ljava/util/ArrayList;

    .line 234
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Landroid/support/v7/view/menu/l;->h:Ljava/util/ArrayList;

    .line 235
    const/4 v0, 0x1

    iput-boolean v0, p0, Landroid/support/v7/view/menu/l;->i:Z

    .line 237
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    iput-object v1, p0, Landroid/support/v7/view/menu/l;->j:Ljava/util/ArrayList;

    .line 238
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    iput-object v1, p0, Landroid/support/v7/view/menu/l;->k:Ljava/util/ArrayList;

    .line 239
    iput-boolean v0, p0, Landroid/support/v7/view/menu/l;->l:Z

    .line 241
    invoke-direct {p0, v0}, Landroid/support/v7/view/menu/l;->e(Z)V

    .line 242
    return-void
.end method

.method private static a(Ljava/util/ArrayList;I)I
    .locals 3
    .param p1, "ordering"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList<",
            "Landroid/support/v7/view/menu/p;",
            ">;I)I"
        }
    .end annotation

    .line 853
    .local p0, "items":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/support/v7/view/menu/MenuItemImpl;>;"
    invoke-virtual {p0}, Ljava/util/ArrayList;->size()I

    move-result v0

    add-int/lit8 v0, v0, -0x1

    .local v0, "i":I
    :goto_0
    if-ltz v0, :cond_1

    .line 854
    invoke-virtual {p0, v0}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/support/v7/view/menu/p;

    .line 855
    .local v1, "item":Landroid/support/v7/view/menu/p;
    invoke-virtual {v1}, Landroid/support/v7/view/menu/p;->c()I

    move-result v2

    if-gt v2, p1, :cond_0

    .line 856
    add-int/lit8 v2, v0, 0x1

    return v2

    .line 853
    .end local v1    # "item":Landroid/support/v7/view/menu/p;
    :cond_0
    add-int/lit8 v0, v0, -0x1

    goto :goto_0

    .line 860
    .end local v0    # "i":I
    :cond_1
    const/4 v0, 0x0

    return v0
.end method

.method private a(IIIILjava/lang/CharSequence;I)Landroid/support/v7/view/menu/p;
    .locals 9
    .param p1, "group"    # I
    .param p2, "id"    # I
    .param p3, "categoryOrder"    # I
    .param p4, "ordering"    # I
    .param p5, "title"    # Ljava/lang/CharSequence;
    .param p6, "defaultShowAsAction"    # I

    .line 466
    new-instance v8, Landroid/support/v7/view/menu/p;

    move-object v0, v8

    move-object v1, p0

    move v2, p1

    move v3, p2

    move v4, p3

    move v5, p4

    move-object v6, p5

    move v7, p6

    invoke-direct/range {v0 .. v7}, Landroid/support/v7/view/menu/p;-><init>(Landroid/support/v7/view/menu/l;IIIILjava/lang/CharSequence;I)V

    return-object v8
.end method

.method private a(ILjava/lang/CharSequence;ILandroid/graphics/drawable/Drawable;Landroid/view/View;)V
    .locals 3
    .param p1, "titleRes"    # I
    .param p2, "title"    # Ljava/lang/CharSequence;
    .param p3, "iconRes"    # I
    .param p4, "icon"    # Landroid/graphics/drawable/Drawable;
    .param p5, "view"    # Landroid/view/View;

    .line 1228
    invoke-virtual {p0}, Landroid/support/v7/view/menu/l;->l()Landroid/content/res/Resources;

    move-result-object v0

    .line 1230
    .local v0, "r":Landroid/content/res/Resources;
    const/4 v1, 0x0

    if-eqz p5, :cond_0

    .line 1231
    iput-object p5, p0, Landroid/support/v7/view/menu/l;->q:Landroid/view/View;

    .line 1234
    iput-object v1, p0, Landroid/support/v7/view/menu/l;->o:Ljava/lang/CharSequence;

    .line 1235
    iput-object v1, p0, Landroid/support/v7/view/menu/l;->p:Landroid/graphics/drawable/Drawable;

    goto :goto_2

    .line 1237
    :cond_0
    if-lez p1, :cond_1

    .line 1238
    invoke-virtual {v0, p1}, Landroid/content/res/Resources;->getText(I)Ljava/lang/CharSequence;

    move-result-object v2

    iput-object v2, p0, Landroid/support/v7/view/menu/l;->o:Ljava/lang/CharSequence;

    goto :goto_0

    .line 1239
    :cond_1
    if-eqz p2, :cond_2

    .line 1240
    iput-object p2, p0, Landroid/support/v7/view/menu/l;->o:Ljava/lang/CharSequence;

    .line 1243
    :cond_2
    :goto_0
    if-lez p3, :cond_3

    .line 1244
    invoke-virtual {p0}, Landroid/support/v7/view/menu/l;->e()Landroid/content/Context;

    move-result-object v2

    invoke-static {v2, p3}, La/b/c/a/a;->b(Landroid/content/Context;I)Landroid/graphics/drawable/Drawable;

    move-result-object v2

    iput-object v2, p0, Landroid/support/v7/view/menu/l;->p:Landroid/graphics/drawable/Drawable;

    goto :goto_1

    .line 1245
    :cond_3
    if-eqz p4, :cond_4

    .line 1246
    iput-object p4, p0, Landroid/support/v7/view/menu/l;->p:Landroid/graphics/drawable/Drawable;

    .line 1250
    :cond_4
    :goto_1
    iput-object v1, p0, Landroid/support/v7/view/menu/l;->q:Landroid/view/View;

    .line 1254
    :goto_2
    const/4 v1, 0x0

    invoke-virtual {p0, v1}, Landroid/support/v7/view/menu/l;->b(Z)V

    .line 1255
    return-void
.end method

.method private a(IZ)V
    .locals 1
    .param p1, "index"    # I
    .param p2, "updateChildrenOnMenuViews"    # Z

    .line 586
    if-ltz p1, :cond_2

    iget-object v0, p0, Landroid/support/v7/view/menu/l;->g:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-lt p1, v0, :cond_0

    goto :goto_0

    .line 588
    :cond_0
    iget-object v0, p0, Landroid/support/v7/view/menu/l;->g:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->remove(I)Ljava/lang/Object;

    .line 590
    if-eqz p2, :cond_1

    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Landroid/support/v7/view/menu/l;->b(Z)V

    .line 591
    :cond_1
    return-void

    .line 586
    :cond_2
    :goto_0
    return-void
.end method

.method private a(Landroid/support/v7/view/menu/D;Landroid/support/v7/view/menu/v;)Z
    .locals 5
    .param p1, "subMenu"    # Landroid/support/v7/view/menu/D;
    .param p2, "preferredPresenter"    # Landroid/support/v7/view/menu/v;

    .line 306
    iget-object v0, p0, Landroid/support/v7/view/menu/l;->x:Ljava/util/concurrent/CopyOnWriteArrayList;

    invoke-virtual {v0}, Ljava/util/concurrent/CopyOnWriteArrayList;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x0

    return v0

    .line 308
    :cond_0
    const/4 v0, 0x0

    .line 311
    .local v0, "result":Z
    if-eqz p2, :cond_1

    .line 312
    invoke-interface {p2, p1}, Landroid/support/v7/view/menu/v;->a(Landroid/support/v7/view/menu/D;)Z

    move-result v0

    .line 315
    :cond_1
    iget-object v1, p0, Landroid/support/v7/view/menu/l;->x:Ljava/util/concurrent/CopyOnWriteArrayList;

    invoke-virtual {v1}, Ljava/util/concurrent/CopyOnWriteArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_4

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/ref/WeakReference;

    .line 316
    .local v2, "ref":Ljava/lang/ref/WeakReference;, "Ljava/lang/ref/WeakReference<Landroid/support/v7/view/menu/MenuPresenter;>;"
    invoke-virtual {v2}, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Landroid/support/v7/view/menu/v;

    .line 317
    .local v3, "presenter":Landroid/support/v7/view/menu/v;
    if-nez v3, :cond_2

    .line 318
    iget-object v4, p0, Landroid/support/v7/view/menu/l;->x:Ljava/util/concurrent/CopyOnWriteArrayList;

    invoke-virtual {v4, v2}, Ljava/util/concurrent/CopyOnWriteArrayList;->remove(Ljava/lang/Object;)Z

    goto :goto_1

    .line 319
    :cond_2
    if-nez v0, :cond_3

    .line 320
    invoke-interface {v3, p1}, Landroid/support/v7/view/menu/v;->a(Landroid/support/v7/view/menu/D;)Z

    move-result v0

    .line 322
    .end local v2    # "ref":Ljava/lang/ref/WeakReference;, "Ljava/lang/ref/WeakReference<Landroid/support/v7/view/menu/MenuPresenter;>;"
    .end local v3    # "presenter":Landroid/support/v7/view/menu/v;
    :cond_3
    :goto_1
    goto :goto_0

    .line 323
    :cond_4
    return v0
.end method

.method private d(Z)V
    .locals 4
    .param p1, "cleared"    # Z

    .line 290
    iget-object v0, p0, Landroid/support/v7/view/menu/l;->x:Ljava/util/concurrent/CopyOnWriteArrayList;

    invoke-virtual {v0}, Ljava/util/concurrent/CopyOnWriteArrayList;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_0

    return-void

    .line 292
    :cond_0
    invoke-virtual {p0}, Landroid/support/v7/view/menu/l;->s()V

    .line 293
    iget-object v0, p0, Landroid/support/v7/view/menu/l;->x:Ljava/util/concurrent/CopyOnWriteArrayList;

    invoke-virtual {v0}, Ljava/util/concurrent/CopyOnWriteArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_2

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/ref/WeakReference;

    .line 294
    .local v1, "ref":Ljava/lang/ref/WeakReference;, "Ljava/lang/ref/WeakReference<Landroid/support/v7/view/menu/MenuPresenter;>;"
    invoke-virtual {v1}, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroid/support/v7/view/menu/v;

    .line 295
    .local v2, "presenter":Landroid/support/v7/view/menu/v;
    if-nez v2, :cond_1

    .line 296
    iget-object v3, p0, Landroid/support/v7/view/menu/l;->x:Ljava/util/concurrent/CopyOnWriteArrayList;

    invoke-virtual {v3, v1}, Ljava/util/concurrent/CopyOnWriteArrayList;->remove(Ljava/lang/Object;)Z

    goto :goto_1

    .line 298
    :cond_1
    invoke-interface {v2, p1}, Landroid/support/v7/view/menu/v;->a(Z)V

    .line 300
    .end local v1    # "ref":Ljava/lang/ref/WeakReference;, "Ljava/lang/ref/WeakReference<Landroid/support/v7/view/menu/MenuPresenter;>;"
    .end local v2    # "presenter":Landroid/support/v7/view/menu/v;
    :goto_1
    goto :goto_0

    .line 301
    :cond_2
    invoke-virtual {p0}, Landroid/support/v7/view/menu/l;->r()V

    .line 302
    return-void
.end method

.method private e(Z)V
    .locals 3
    .param p1, "shortcutsVisible"    # Z

    .line 818
    const/4 v0, 0x1

    if-eqz p1, :cond_0

    iget-object v1, p0, Landroid/support/v7/view/menu/l;->c:Landroid/content/res/Resources;

    .line 819
    invoke-virtual {v1}, Landroid/content/res/Resources;->getConfiguration()Landroid/content/res/Configuration;

    move-result-object v1

    iget v1, v1, Landroid/content/res/Configuration;->keyboard:I

    if-eq v1, v0, :cond_0

    iget-object v1, p0, Landroid/support/v7/view/menu/l;->b:Landroid/content/Context;

    .line 821
    invoke-static {v1}, Landroid/view/ViewConfiguration;->get(Landroid/content/Context;)Landroid/view/ViewConfiguration;

    move-result-object v1

    iget-object v2, p0, Landroid/support/v7/view/menu/l;->b:Landroid/content/Context;

    .line 820
    invoke-static {v1, v2}, La/b/c/g/v;->a(Landroid/view/ViewConfiguration;Landroid/content/Context;)Z

    move-result v1

    if-eqz v1, :cond_0

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    :goto_0
    iput-boolean v0, p0, Landroid/support/v7/view/menu/l;->e:Z

    .line 822
    return-void
.end method

.method private static f(I)I
    .locals 3
    .param p0, "categoryOrder"    # I

    .line 785
    const/high16 v0, -0x10000

    and-int/2addr v0, p0

    shr-int/lit8 v0, v0, 0x10

    .line 787
    .local v0, "index":I
    if-ltz v0, :cond_0

    sget-object v1, Landroid/support/v7/view/menu/l;->a:[I

    array-length v2, v1

    if-ge v0, v2, :cond_0

    .line 791
    aget v1, v1, v0

    shl-int/lit8 v1, v1, 0x10

    const v2, 0xffff

    and-int/2addr v2, p0

    or-int/2addr v1, v2

    return v1

    .line 788
    :cond_0
    new-instance v1, Ljava/lang/IllegalArgumentException;

    const-string v2, "order does not contain a valid category."

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1
.end method


# virtual methods
.method public a(I)I
    .locals 1
    .param p1, "group"    # I

    .line 730
    const/4 v0, 0x0

    invoke-virtual {p0, p1, v0}, Landroid/support/v7/view/menu/l;->a(II)I

    move-result v0

    return v0
.end method

.method public a(II)I
    .locals 4
    .param p1, "group"    # I
    .param p2, "start"    # I

    .line 734
    invoke-virtual {p0}, Landroid/support/v7/view/menu/l;->size()I

    move-result v0

    .line 736
    .local v0, "size":I
    if-gez p2, :cond_0

    .line 737
    const/4 p2, 0x0

    .line 740
    :cond_0
    move v1, p2

    .local v1, "i":I
    :goto_0
    if-ge v1, v0, :cond_2

    .line 741
    iget-object v2, p0, Landroid/support/v7/view/menu/l;->g:Ljava/util/ArrayList;

    invoke-virtual {v2, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroid/support/v7/view/menu/p;

    .line 743
    .local v2, "item":Landroid/support/v7/view/menu/p;
    invoke-virtual {v2}, Landroid/support/v7/view/menu/p;->getGroupId()I

    move-result v3

    if-ne v3, p1, :cond_1

    .line 744
    return v1

    .line 740
    .end local v2    # "item":Landroid/support/v7/view/menu/p;
    :cond_1
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 748
    .end local v1    # "i":I
    :cond_2
    const/4 v1, -0x1

    return v1
.end method

.method protected a(Landroid/graphics/drawable/Drawable;)Landroid/support/v7/view/menu/l;
    .locals 6
    .param p1, "icon"    # Landroid/graphics/drawable/Drawable;

    .line 1289
    const/4 v1, 0x0

    const/4 v2, 0x0

    const/4 v3, 0x0

    const/4 v5, 0x0

    move-object v0, p0

    move-object v4, p1

    invoke-direct/range {v0 .. v5}, Landroid/support/v7/view/menu/l;->a(ILjava/lang/CharSequence;ILandroid/graphics/drawable/Drawable;Landroid/view/View;)V

    .line 1290
    return-object p0
.end method

.method protected a(Landroid/view/View;)Landroid/support/v7/view/menu/l;
    .locals 6
    .param p1, "view"    # Landroid/view/View;

    .line 1313
    const/4 v1, 0x0

    const/4 v2, 0x0

    const/4 v3, 0x0

    const/4 v4, 0x0

    move-object v0, p0

    move-object v5, p1

    invoke-direct/range {v0 .. v5}, Landroid/support/v7/view/menu/l;->a(ILjava/lang/CharSequence;ILandroid/graphics/drawable/Drawable;Landroid/view/View;)V

    .line 1314
    return-object p0
.end method

.method protected a(Ljava/lang/CharSequence;)Landroid/support/v7/view/menu/l;
    .locals 6
    .param p1, "title"    # Ljava/lang/CharSequence;

    .line 1265
    const/4 v1, 0x0

    const/4 v3, 0x0

    const/4 v4, 0x0

    const/4 v5, 0x0

    move-object v0, p0

    move-object v2, p1

    invoke-direct/range {v0 .. v5}, Landroid/support/v7/view/menu/l;->a(ILjava/lang/CharSequence;ILandroid/graphics/drawable/Drawable;Landroid/view/View;)V

    .line 1266
    return-object p0
.end method

.method a(ILandroid/view/KeyEvent;)Landroid/support/v7/view/menu/p;
    .locals 12
    .param p1, "keyCode"    # I
    .param p2, "event"    # Landroid/view/KeyEvent;

    .line 936
    iget-object v0, p0, Landroid/support/v7/view/menu/l;->w:Ljava/util/ArrayList;

    .line 937
    .local v0, "items":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/support/v7/view/menu/MenuItemImpl;>;"
    invoke-virtual {v0}, Ljava/util/ArrayList;->clear()V

    .line 938
    invoke-virtual {p0, v0, p1, p2}, Landroid/support/v7/view/menu/l;->a(Ljava/util/List;ILandroid/view/KeyEvent;)V

    .line 940
    invoke-virtual {v0}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v1

    const/4 v2, 0x0

    if-eqz v1, :cond_0

    .line 941
    return-object v2

    .line 944
    :cond_0
    invoke-virtual {p2}, Landroid/view/KeyEvent;->getMetaState()I

    move-result v1

    .line 945
    .local v1, "metaState":I
    new-instance v3, Landroid/view/KeyCharacterMap$KeyData;

    invoke-direct {v3}, Landroid/view/KeyCharacterMap$KeyData;-><init>()V

    .line 947
    .local v3, "possibleChars":Landroid/view/KeyCharacterMap$KeyData;
    invoke-virtual {p2, v3}, Landroid/view/KeyEvent;->getKeyData(Landroid/view/KeyCharacterMap$KeyData;)Z

    .line 950
    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v4

    .line 951
    .local v4, "size":I
    const/4 v5, 0x0

    const/4 v6, 0x1

    if-ne v4, v6, :cond_1

    .line 952
    invoke-virtual {v0, v5}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroid/support/v7/view/menu/p;

    return-object v2

    .line 955
    :cond_1
    invoke-virtual {p0}, Landroid/support/v7/view/menu/l;->p()Z

    move-result v6

    .line 958
    .local v6, "qwerty":Z
    const/4 v7, 0x0

    .local v7, "i":I
    :goto_0
    if-ge v7, v4, :cond_7

    .line 959
    invoke-virtual {v0, v7}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Landroid/support/v7/view/menu/p;

    .line 960
    .local v8, "item":Landroid/support/v7/view/menu/p;
    if-eqz v6, :cond_2

    invoke-virtual {v8}, Landroid/support/v7/view/menu/p;->getAlphabeticShortcut()C

    move-result v9

    goto :goto_1

    .line 961
    :cond_2
    invoke-virtual {v8}, Landroid/support/v7/view/menu/p;->getNumericShortcut()C

    move-result v9

    :goto_1
    nop

    .line 962
    .local v9, "shortcutChar":C
    iget-object v10, v3, Landroid/view/KeyCharacterMap$KeyData;->meta:[C

    aget-char v10, v10, v5

    if-ne v9, v10, :cond_3

    and-int/lit8 v10, v1, 0x2

    if-eqz v10, :cond_5

    :cond_3
    iget-object v10, v3, Landroid/view/KeyCharacterMap$KeyData;->meta:[C

    const/4 v11, 0x2

    aget-char v10, v10, v11

    if-ne v9, v10, :cond_4

    and-int/lit8 v10, v1, 0x2

    if-nez v10, :cond_5

    :cond_4
    if-eqz v6, :cond_6

    const/16 v10, 0x8

    if-ne v9, v10, :cond_6

    const/16 v10, 0x43

    if-ne p1, v10, :cond_6

    .line 968
    :cond_5
    return-object v8

    .line 958
    .end local v8    # "item":Landroid/support/v7/view/menu/p;
    .end local v9    # "shortcutChar":C
    :cond_6
    add-int/lit8 v7, v7, 0x1

    goto :goto_0

    .line 971
    .end local v7    # "i":I
    :cond_7
    return-object v2
.end method

.method protected a(IIILjava/lang/CharSequence;)Landroid/view/MenuItem;
    .locals 8
    .param p1, "group"    # I
    .param p2, "id"    # I
    .param p3, "categoryOrder"    # I
    .param p4, "title"    # Ljava/lang/CharSequence;

    .line 447
    invoke-static {p3}, Landroid/support/v7/view/menu/l;->f(I)I

    move-result v7

    .line 449
    .local v7, "ordering":I
    iget v6, p0, Landroid/support/v7/view/menu/l;->m:I

    move-object v0, p0

    move v1, p1

    move v2, p2

    move v3, p3

    move v4, v7

    move-object v5, p4

    invoke-direct/range {v0 .. v6}, Landroid/support/v7/view/menu/l;->a(IIIILjava/lang/CharSequence;I)Landroid/support/v7/view/menu/p;

    move-result-object v0

    .line 452
    .local v0, "item":Landroid/support/v7/view/menu/p;
    iget-object v1, p0, Landroid/support/v7/view/menu/l;->n:Landroid/view/ContextMenu$ContextMenuInfo;

    if-eqz v1, :cond_0

    .line 454
    invoke-virtual {v0, v1}, Landroid/support/v7/view/menu/p;->a(Landroid/view/ContextMenu$ContextMenuInfo;)V

    .line 457
    :cond_0
    iget-object v1, p0, Landroid/support/v7/view/menu/l;->g:Ljava/util/ArrayList;

    invoke-static {v1, v7}, Landroid/support/v7/view/menu/l;->a(Ljava/util/ArrayList;I)I

    move-result v2

    invoke-virtual {v1, v2, v0}, Ljava/util/ArrayList;->add(ILjava/lang/Object;)V

    .line 458
    const/4 v1, 0x1

    invoke-virtual {p0, v1}, Landroid/support/v7/view/menu/l;->b(Z)V

    .line 460
    return-object v0
.end method

.method public a()V
    .locals 1

    .line 847
    iget-object v0, p0, Landroid/support/v7/view/menu/l;->f:Landroid/support/v7/view/menu/l$a;

    if-eqz v0, :cond_0

    .line 848
    invoke-interface {v0, p0}, Landroid/support/v7/view/menu/l$a;->a(Landroid/support/v7/view/menu/l;)V

    .line 850
    :cond_0
    return-void
.end method

.method public a(Landroid/os/Bundle;)V
    .locals 7
    .param p1, "states"    # Landroid/os/Bundle;

    .line 406
    if-nez p1, :cond_0

    .line 407
    return-void

    .line 410
    :cond_0
    nop

    .line 411
    invoke-virtual {p0}, Landroid/support/v7/view/menu/l;->d()Ljava/lang/String;

    move-result-object v0

    .line 410
    invoke-virtual {p1, v0}, Landroid/os/Bundle;->getSparseParcelableArray(Ljava/lang/String;)Landroid/util/SparseArray;

    move-result-object v0

    .line 413
    .local v0, "viewStates":Landroid/util/SparseArray;, "Landroid/util/SparseArray<Landroid/os/Parcelable;>;"
    invoke-virtual {p0}, Landroid/support/v7/view/menu/l;->size()I

    move-result v1

    .line 414
    .local v1, "itemCount":I
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_0
    if-ge v2, v1, :cond_3

    .line 415
    invoke-virtual {p0, v2}, Landroid/support/v7/view/menu/l;->getItem(I)Landroid/view/MenuItem;

    move-result-object v3

    .line 416
    .local v3, "item":Landroid/view/MenuItem;
    invoke-interface {v3}, Landroid/view/MenuItem;->getActionView()Landroid/view/View;

    move-result-object v4

    .line 417
    .local v4, "v":Landroid/view/View;
    if-eqz v4, :cond_1

    invoke-virtual {v4}, Landroid/view/View;->getId()I

    move-result v5

    const/4 v6, -0x1

    if-eq v5, v6, :cond_1

    .line 418
    invoke-virtual {v4, v0}, Landroid/view/View;->restoreHierarchyState(Landroid/util/SparseArray;)V

    .line 420
    :cond_1
    invoke-interface {v3}, Landroid/view/MenuItem;->hasSubMenu()Z

    move-result v5

    if-eqz v5, :cond_2

    .line 421
    invoke-interface {v3}, Landroid/view/MenuItem;->getSubMenu()Landroid/view/SubMenu;

    move-result-object v5

    check-cast v5, Landroid/support/v7/view/menu/D;

    .line 422
    .local v5, "subMenu":Landroid/support/v7/view/menu/D;
    invoke-virtual {v5, p1}, Landroid/support/v7/view/menu/l;->a(Landroid/os/Bundle;)V

    .line 414
    .end local v3    # "item":Landroid/view/MenuItem;
    .end local v4    # "v":Landroid/view/View;
    .end local v5    # "subMenu":Landroid/support/v7/view/menu/D;
    :cond_2
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 426
    .end local v2    # "i":I
    :cond_3
    const-string v2, "android:menu:expandedactionview"

    invoke-virtual {p1, v2}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v2

    .line 427
    .local v2, "expandedId":I
    if-lez v2, :cond_4

    .line 428
    invoke-virtual {p0, v2}, Landroid/support/v7/view/menu/l;->findItem(I)Landroid/view/MenuItem;

    move-result-object v3

    .line 429
    .local v3, "itemToExpand":Landroid/view/MenuItem;
    if-eqz v3, :cond_4

    .line 430
    invoke-interface {v3}, Landroid/view/MenuItem;->expandActionView()Z

    .line 433
    .end local v3    # "itemToExpand":Landroid/view/MenuItem;
    :cond_4
    return-void
.end method

.method public a(Landroid/support/v7/view/menu/l$a;)V
    .locals 0
    .param p1, "cb"    # Landroid/support/v7/view/menu/l$a;

    .line 440
    iput-object p1, p0, Landroid/support/v7/view/menu/l;->f:Landroid/support/v7/view/menu/l$a;

    .line 441
    return-void
.end method

.method public a(Landroid/support/v7/view/menu/v;)V
    .locals 1
    .param p1, "presenter"    # Landroid/support/v7/view/menu/v;

    .line 256
    iget-object v0, p0, Landroid/support/v7/view/menu/l;->b:Landroid/content/Context;

    invoke-virtual {p0, p1, v0}, Landroid/support/v7/view/menu/l;->a(Landroid/support/v7/view/menu/v;Landroid/content/Context;)V

    .line 257
    return-void
.end method

.method public a(Landroid/support/v7/view/menu/v;Landroid/content/Context;)V
    .locals 2
    .param p1, "presenter"    # Landroid/support/v7/view/menu/v;
    .param p2, "menuContext"    # Landroid/content/Context;

    .line 269
    iget-object v0, p0, Landroid/support/v7/view/menu/l;->x:Ljava/util/concurrent/CopyOnWriteArrayList;

    new-instance v1, Ljava/lang/ref/WeakReference;

    invoke-direct {v1, p1}, Ljava/lang/ref/WeakReference;-><init>(Ljava/lang/Object;)V

    invoke-virtual {v0, v1}, Ljava/util/concurrent/CopyOnWriteArrayList;->add(Ljava/lang/Object;)Z

    .line 270
    invoke-interface {p1, p2, p0}, Landroid/support/v7/view/menu/v;->a(Landroid/content/Context;Landroid/support/v7/view/menu/l;)V

    .line 271
    const/4 v0, 0x1

    iput-boolean v0, p0, Landroid/support/v7/view/menu/l;->l:Z

    .line 272
    return-void
.end method

.method a(Landroid/view/MenuItem;)V
    .locals 5
    .param p1, "item"    # Landroid/view/MenuItem;

    .line 619
    invoke-interface {p1}, Landroid/view/MenuItem;->getGroupId()I

    move-result v0

    .line 621
    .local v0, "group":I
    iget-object v1, p0, Landroid/support/v7/view/menu/l;->g:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v1

    .line 622
    .local v1, "N":I
    invoke-virtual {p0}, Landroid/support/v7/view/menu/l;->s()V

    .line 623
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_0
    if-ge v2, v1, :cond_4

    .line 624
    iget-object v3, p0, Landroid/support/v7/view/menu/l;->g:Ljava/util/ArrayList;

    invoke-virtual {v3, v2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Landroid/support/v7/view/menu/p;

    .line 625
    .local v3, "curItem":Landroid/support/v7/view/menu/p;
    invoke-virtual {v3}, Landroid/support/v7/view/menu/p;->getGroupId()I

    move-result v4

    if-ne v4, v0, :cond_3

    .line 626
    invoke-virtual {v3}, Landroid/support/v7/view/menu/p;->i()Z

    move-result v4

    if-nez v4, :cond_0

    goto :goto_2

    .line 627
    :cond_0
    invoke-virtual {v3}, Landroid/support/v7/view/menu/p;->isCheckable()Z

    move-result v4

    if-nez v4, :cond_1

    goto :goto_2

    .line 630
    :cond_1
    if-ne v3, p1, :cond_2

    const/4 v4, 0x1

    goto :goto_1

    :cond_2
    const/4 v4, 0x0

    :goto_1
    invoke-virtual {v3, v4}, Landroid/support/v7/view/menu/p;->b(Z)V

    .line 623
    .end local v3    # "curItem":Landroid/support/v7/view/menu/p;
    :cond_3
    :goto_2
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 633
    .end local v2    # "i":I
    :cond_4
    invoke-virtual {p0}, Landroid/support/v7/view/menu/l;->r()V

    .line 634
    return-void
.end method

.method a(Ljava/util/List;ILandroid/view/KeyEvent;)V
    .locals 17
    .param p2, "keyCode"    # I
    .param p3, "event"    # Landroid/view/KeyEvent;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List<",
            "Landroid/support/v7/view/menu/p;",
            ">;I",
            "Landroid/view/KeyEvent;",
            ")V"
        }
    .end annotation

    .line 888
    .local p1, "items":Ljava/util/List;, "Ljava/util/List<Landroid/support/v7/view/menu/MenuItemImpl;>;"
    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move/from16 v2, p2

    move-object/from16 v3, p3

    invoke-virtual/range {p0 .. p0}, Landroid/support/v7/view/menu/l;->p()Z

    move-result v4

    .line 889
    .local v4, "qwerty":Z
    invoke-virtual/range {p3 .. p3}, Landroid/view/KeyEvent;->getModifiers()I

    move-result v5

    .line 890
    .local v5, "modifierState":I
    new-instance v6, Landroid/view/KeyCharacterMap$KeyData;

    invoke-direct {v6}, Landroid/view/KeyCharacterMap$KeyData;-><init>()V

    .line 892
    .local v6, "possibleChars":Landroid/view/KeyCharacterMap$KeyData;
    invoke-virtual {v3, v6}, Landroid/view/KeyEvent;->getKeyData(Landroid/view/KeyCharacterMap$KeyData;)Z

    move-result v7

    .line 894
    .local v7, "isKeyCodeMapped":Z
    const/16 v8, 0x43

    if-nez v7, :cond_0

    if-eq v2, v8, :cond_0

    .line 895
    return-void

    .line 899
    :cond_0
    iget-object v9, v0, Landroid/support/v7/view/menu/l;->g:Ljava/util/ArrayList;

    invoke-virtual {v9}, Ljava/util/ArrayList;->size()I

    move-result v9

    .line 900
    .local v9, "N":I
    const/4 v10, 0x0

    .local v10, "i":I
    :goto_0
    if-ge v10, v9, :cond_8

    .line 901
    iget-object v11, v0, Landroid/support/v7/view/menu/l;->g:Ljava/util/ArrayList;

    invoke-virtual {v11, v10}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v11

    check-cast v11, Landroid/support/v7/view/menu/p;

    .line 902
    .local v11, "item":Landroid/support/v7/view/menu/p;
    invoke-virtual {v11}, Landroid/support/v7/view/menu/p;->hasSubMenu()Z

    move-result v12

    if-eqz v12, :cond_1

    .line 903
    invoke-virtual {v11}, Landroid/support/v7/view/menu/p;->getSubMenu()Landroid/view/SubMenu;

    move-result-object v12

    check-cast v12, Landroid/support/v7/view/menu/l;

    invoke-virtual {v12, v1, v2, v3}, Landroid/support/v7/view/menu/l;->a(Ljava/util/List;ILandroid/view/KeyEvent;)V

    .line 905
    :cond_1
    if-eqz v4, :cond_2

    .line 906
    invoke-virtual {v11}, Landroid/support/v7/view/menu/p;->getAlphabeticShortcut()C

    move-result v12

    goto :goto_1

    :cond_2
    invoke-virtual {v11}, Landroid/support/v7/view/menu/p;->getNumericShortcut()C

    move-result v12

    .line 907
    .local v12, "shortcutChar":C
    :goto_1
    if-eqz v4, :cond_3

    .line 908
    invoke-virtual {v11}, Landroid/support/v7/view/menu/p;->getAlphabeticModifiers()I

    move-result v13

    goto :goto_2

    :cond_3
    invoke-virtual {v11}, Landroid/support/v7/view/menu/p;->getNumericModifiers()I

    move-result v13

    .line 909
    .local v13, "shortcutModifiers":I
    :goto_2
    const v14, 0x1100f

    and-int v15, v5, v14

    and-int/2addr v14, v13

    const/16 v16, 0x0

    if-ne v15, v14, :cond_4

    const/4 v14, 0x1

    goto :goto_3

    :cond_4
    const/4 v14, 0x0

    .line 911
    .local v14, "isModifiersExactMatch":Z
    :goto_3
    if-eqz v14, :cond_7

    if-eqz v12, :cond_7

    iget-object v15, v6, Landroid/view/KeyCharacterMap$KeyData;->meta:[C

    aget-char v8, v15, v16

    if-eq v12, v8, :cond_6

    const/4 v8, 0x2

    aget-char v8, v15, v8

    if-eq v12, v8, :cond_6

    if-eqz v4, :cond_5

    const/16 v8, 0x8

    if-ne v12, v8, :cond_5

    const/16 v8, 0x43

    if-ne v2, v8, :cond_7

    goto :goto_4

    :cond_5
    const/16 v8, 0x43

    goto :goto_5

    :cond_6
    const/16 v8, 0x43

    .line 916
    :goto_4
    invoke-virtual {v11}, Landroid/support/v7/view/menu/p;->isEnabled()Z

    move-result v15

    if-eqz v15, :cond_7

    .line 917
    invoke-interface {v1, v11}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 900
    .end local v11    # "item":Landroid/support/v7/view/menu/p;
    .end local v12    # "shortcutChar":C
    .end local v13    # "shortcutModifiers":I
    .end local v14    # "isModifiersExactMatch":Z
    :cond_7
    :goto_5
    add-int/lit8 v10, v10, 0x1

    goto :goto_0

    .line 920
    .end local v10    # "i":I
    :cond_8
    return-void
.end method

.method public final a(Z)V
    .locals 4
    .param p1, "closeAllMenus"    # Z

    .line 1036
    iget-boolean v0, p0, Landroid/support/v7/view/menu/l;->v:Z

    if-eqz v0, :cond_0

    return-void

    .line 1038
    :cond_0
    const/4 v0, 0x1

    iput-boolean v0, p0, Landroid/support/v7/view/menu/l;->v:Z

    .line 1039
    iget-object v0, p0, Landroid/support/v7/view/menu/l;->x:Ljava/util/concurrent/CopyOnWriteArrayList;

    invoke-virtual {v0}, Ljava/util/concurrent/CopyOnWriteArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_2

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/ref/WeakReference;

    .line 1040
    .local v1, "ref":Ljava/lang/ref/WeakReference;, "Ljava/lang/ref/WeakReference<Landroid/support/v7/view/menu/MenuPresenter;>;"
    invoke-virtual {v1}, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroid/support/v7/view/menu/v;

    .line 1041
    .local v2, "presenter":Landroid/support/v7/view/menu/v;
    if-nez v2, :cond_1

    .line 1042
    iget-object v3, p0, Landroid/support/v7/view/menu/l;->x:Ljava/util/concurrent/CopyOnWriteArrayList;

    invoke-virtual {v3, v1}, Ljava/util/concurrent/CopyOnWriteArrayList;->remove(Ljava/lang/Object;)Z

    goto :goto_1

    .line 1044
    :cond_1
    invoke-interface {v2, p0, p1}, Landroid/support/v7/view/menu/v;->a(Landroid/support/v7/view/menu/l;Z)V

    .line 1046
    .end local v1    # "ref":Ljava/lang/ref/WeakReference;, "Ljava/lang/ref/WeakReference<Landroid/support/v7/view/menu/MenuPresenter;>;"
    .end local v2    # "presenter":Landroid/support/v7/view/menu/v;
    :goto_1
    goto :goto_0

    .line 1047
    :cond_2
    const/4 v0, 0x0

    iput-boolean v0, p0, Landroid/support/v7/view/menu/l;->v:Z

    .line 1048
    return-void
.end method

.method a(Landroid/support/v7/view/menu/l;Landroid/view/MenuItem;)Z
    .locals 1
    .param p1, "menu"    # Landroid/support/v7/view/menu/l;
    .param p2, "item"    # Landroid/view/MenuItem;

    .line 840
    iget-object v0, p0, Landroid/support/v7/view/menu/l;->f:Landroid/support/v7/view/menu/l$a;

    if-eqz v0, :cond_0

    invoke-interface {v0, p1, p2}, Landroid/support/v7/view/menu/l$a;->a(Landroid/support/v7/view/menu/l;Landroid/view/MenuItem;)Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    :goto_0
    return v0
.end method

.method public a(Landroid/support/v7/view/menu/p;)Z
    .locals 5
    .param p1, "item"    # Landroid/support/v7/view/menu/p;

    .line 1379
    iget-object v0, p0, Landroid/support/v7/view/menu/l;->x:Ljava/util/concurrent/CopyOnWriteArrayList;

    invoke-virtual {v0}, Ljava/util/concurrent/CopyOnWriteArrayList;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_5

    iget-object v0, p0, Landroid/support/v7/view/menu/l;->y:Landroid/support/v7/view/menu/p;

    if-eq v0, p1, :cond_0

    goto :goto_3

    .line 1381
    :cond_0
    const/4 v0, 0x0

    .line 1383
    .local v0, "collapsed":Z
    invoke-virtual {p0}, Landroid/support/v7/view/menu/l;->s()V

    .line 1384
    iget-object v1, p0, Landroid/support/v7/view/menu/l;->x:Ljava/util/concurrent/CopyOnWriteArrayList;

    invoke-virtual {v1}, Ljava/util/concurrent/CopyOnWriteArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_3

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/ref/WeakReference;

    .line 1385
    .local v2, "ref":Ljava/lang/ref/WeakReference;, "Ljava/lang/ref/WeakReference<Landroid/support/v7/view/menu/MenuPresenter;>;"
    invoke-virtual {v2}, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Landroid/support/v7/view/menu/v;

    .line 1386
    .local v3, "presenter":Landroid/support/v7/view/menu/v;
    if-nez v3, :cond_1

    .line 1387
    iget-object v4, p0, Landroid/support/v7/view/menu/l;->x:Ljava/util/concurrent/CopyOnWriteArrayList;

    invoke-virtual {v4, v2}, Ljava/util/concurrent/CopyOnWriteArrayList;->remove(Ljava/lang/Object;)Z

    goto :goto_1

    .line 1388
    :cond_1
    invoke-interface {v3, p0, p1}, Landroid/support/v7/view/menu/v;->b(Landroid/support/v7/view/menu/l;Landroid/support/v7/view/menu/p;)Z

    move-result v4

    move v0, v4

    if-eqz v4, :cond_2

    .line 1389
    goto :goto_2

    .line 1391
    .end local v2    # "ref":Ljava/lang/ref/WeakReference;, "Ljava/lang/ref/WeakReference<Landroid/support/v7/view/menu/MenuPresenter;>;"
    .end local v3    # "presenter":Landroid/support/v7/view/menu/v;
    :cond_2
    :goto_1
    goto :goto_0

    .line 1392
    :cond_3
    :goto_2
    invoke-virtual {p0}, Landroid/support/v7/view/menu/l;->r()V

    .line 1394
    if-eqz v0, :cond_4

    .line 1395
    const/4 v1, 0x0

    iput-object v1, p0, Landroid/support/v7/view/menu/l;->y:Landroid/support/v7/view/menu/p;

    .line 1397
    :cond_4
    return v0

    .line 1379
    .end local v0    # "collapsed":Z
    :cond_5
    :goto_3
    const/4 v0, 0x0

    return v0
.end method

.method public a(Landroid/view/MenuItem;I)Z
    .locals 1
    .param p1, "item"    # Landroid/view/MenuItem;
    .param p2, "flags"    # I

    .line 981
    const/4 v0, 0x0

    invoke-virtual {p0, p1, v0, p2}, Landroid/support/v7/view/menu/l;->a(Landroid/view/MenuItem;Landroid/support/v7/view/menu/v;I)Z

    move-result v0

    return v0
.end method

.method public a(Landroid/view/MenuItem;Landroid/support/v7/view/menu/v;I)Z
    .locals 7
    .param p1, "item"    # Landroid/view/MenuItem;
    .param p2, "preferredPresenter"    # Landroid/support/v7/view/menu/v;
    .param p3, "flags"    # I

    .line 985
    move-object v0, p1

    check-cast v0, Landroid/support/v7/view/menu/p;

    .line 987
    .local v0, "itemImpl":Landroid/support/v7/view/menu/p;
    const/4 v1, 0x0

    if-eqz v0, :cond_a

    invoke-virtual {v0}, Landroid/support/v7/view/menu/p;->isEnabled()Z

    move-result v2

    if-nez v2, :cond_0

    goto :goto_3

    .line 991
    :cond_0
    invoke-virtual {v0}, Landroid/support/v7/view/menu/p;->g()Z

    move-result v2

    .line 993
    .local v2, "invoked":Z
    invoke-virtual {v0}, Landroid/support/v7/view/menu/p;->a()La/b/c/g/e;

    move-result-object v3

    .line 994
    .local v3, "provider":La/b/c/g/e;
    const/4 v4, 0x1

    if-eqz v3, :cond_1

    invoke-virtual {v3}, La/b/c/g/e;->a()Z

    move-result v5

    if-eqz v5, :cond_1

    const/4 v5, 0x1

    goto :goto_0

    :cond_1
    const/4 v5, 0x0

    .line 995
    .local v5, "providerHasSubMenu":Z
    :goto_0
    invoke-virtual {v0}, Landroid/support/v7/view/menu/p;->f()Z

    move-result v6

    if-eqz v6, :cond_2

    .line 996
    invoke-virtual {v0}, Landroid/support/v7/view/menu/p;->expandActionView()Z

    move-result v1

    or-int/2addr v2, v1

    .line 997
    if-eqz v2, :cond_9

    .line 998
    invoke-virtual {p0, v4}, Landroid/support/v7/view/menu/l;->a(Z)V

    goto :goto_2

    .line 1000
    :cond_2
    invoke-virtual {v0}, Landroid/support/v7/view/menu/p;->hasSubMenu()Z

    move-result v6

    if-nez v6, :cond_4

    if-eqz v5, :cond_3

    goto :goto_1

    .line 1019
    :cond_3
    and-int/lit8 v1, p3, 0x1

    if-nez v1, :cond_9

    .line 1020
    invoke-virtual {p0, v4}, Landroid/support/v7/view/menu/l;->a(Z)V

    goto :goto_2

    .line 1001
    :cond_4
    :goto_1
    and-int/lit8 v6, p3, 0x4

    if-nez v6, :cond_5

    .line 1003
    invoke-virtual {p0, v1}, Landroid/support/v7/view/menu/l;->a(Z)V

    .line 1006
    :cond_5
    invoke-virtual {v0}, Landroid/support/v7/view/menu/p;->hasSubMenu()Z

    move-result v1

    if-nez v1, :cond_6

    .line 1007
    new-instance v1, Landroid/support/v7/view/menu/D;

    invoke-virtual {p0}, Landroid/support/v7/view/menu/l;->e()Landroid/content/Context;

    move-result-object v6

    invoke-direct {v1, v6, p0, v0}, Landroid/support/v7/view/menu/D;-><init>(Landroid/content/Context;Landroid/support/v7/view/menu/l;Landroid/support/v7/view/menu/p;)V

    invoke-virtual {v0, v1}, Landroid/support/v7/view/menu/p;->a(Landroid/support/v7/view/menu/D;)V

    .line 1010
    :cond_6
    invoke-virtual {v0}, Landroid/support/v7/view/menu/p;->getSubMenu()Landroid/view/SubMenu;

    move-result-object v1

    check-cast v1, Landroid/support/v7/view/menu/D;

    .line 1011
    .local v1, "subMenu":Landroid/support/v7/view/menu/D;
    if-eqz v5, :cond_7

    .line 1012
    invoke-virtual {v3, v1}, La/b/c/g/e;->a(Landroid/view/SubMenu;)V

    .line 1014
    :cond_7
    invoke-direct {p0, v1, p2}, Landroid/support/v7/view/menu/l;->a(Landroid/support/v7/view/menu/D;Landroid/support/v7/view/menu/v;)Z

    move-result v6

    or-int/2addr v2, v6

    .line 1015
    if-nez v2, :cond_8

    .line 1016
    invoke-virtual {p0, v4}, Landroid/support/v7/view/menu/l;->a(Z)V

    .line 1018
    .end local v1    # "subMenu":Landroid/support/v7/view/menu/D;
    :cond_8
    nop

    .line 1024
    :cond_9
    :goto_2
    return v2

    .line 988
    .end local v2    # "invoked":Z
    .end local v3    # "provider":La/b/c/g/e;
    .end local v5    # "providerHasSubMenu":Z
    :cond_a
    :goto_3
    return v1
.end method

.method public add(I)Landroid/view/MenuItem;
    .locals 2
    .param p1, "titleRes"    # I

    .line 477
    iget-object v0, p0, Landroid/support/v7/view/menu/l;->c:Landroid/content/res/Resources;

    invoke-virtual {v0, p1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {p0, v1, v1, v1, v0}, Landroid/support/v7/view/menu/l;->a(IIILjava/lang/CharSequence;)Landroid/view/MenuItem;

    move-result-object v0

    return-object v0
.end method

.method public add(IIII)Landroid/view/MenuItem;
    .locals 1
    .param p1, "group"    # I
    .param p2, "id"    # I
    .param p3, "categoryOrder"    # I
    .param p4, "title"    # I

    .line 487
    iget-object v0, p0, Landroid/support/v7/view/menu/l;->c:Landroid/content/res/Resources;

    invoke-virtual {v0, p4}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, p1, p2, p3, v0}, Landroid/support/v7/view/menu/l;->a(IIILjava/lang/CharSequence;)Landroid/view/MenuItem;

    move-result-object v0

    return-object v0
.end method

.method public add(IIILjava/lang/CharSequence;)Landroid/view/MenuItem;
    .locals 1
    .param p1, "group"    # I
    .param p2, "id"    # I
    .param p3, "categoryOrder"    # I
    .param p4, "title"    # Ljava/lang/CharSequence;

    .line 482
    invoke-virtual {p0, p1, p2, p3, p4}, Landroid/support/v7/view/menu/l;->a(IIILjava/lang/CharSequence;)Landroid/view/MenuItem;

    move-result-object v0

    return-object v0
.end method

.method public add(Ljava/lang/CharSequence;)Landroid/view/MenuItem;
    .locals 1
    .param p1, "title"    # Ljava/lang/CharSequence;

    .line 472
    const/4 v0, 0x0

    invoke-virtual {p0, v0, v0, v0, p1}, Landroid/support/v7/view/menu/l;->a(IIILjava/lang/CharSequence;)Landroid/view/MenuItem;

    move-result-object v0

    return-object v0
.end method

.method public addIntentOptions(IIILandroid/content/ComponentName;[Landroid/content/Intent;Landroid/content/Intent;I[Landroid/view/MenuItem;)I
    .locals 15
    .param p1, "group"    # I
    .param p2, "id"    # I
    .param p3, "categoryOrder"    # I
    .param p4, "caller"    # Landroid/content/ComponentName;
    .param p5, "specifics"    # [Landroid/content/Intent;
    .param p6, "intent"    # Landroid/content/Intent;
    .param p7, "flags"    # I
    .param p8, "outSpecificItems"    # [Landroid/view/MenuItem;

    .line 526
    move-object v0, p0

    move-object/from16 v1, p5

    iget-object v2, v0, Landroid/support/v7/view/menu/l;->b:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v2

    .line 527
    .local v2, "pm":Landroid/content/pm/PackageManager;
    nop

    .line 528
    const/4 v3, 0x0

    move-object/from16 v4, p4

    move-object/from16 v5, p6

    invoke-virtual {v2, v4, v1, v5, v3}, Landroid/content/pm/PackageManager;->queryIntentActivityOptions(Landroid/content/ComponentName;[Landroid/content/Intent;Landroid/content/Intent;I)Ljava/util/List;

    move-result-object v6

    .line 529
    .local v6, "lri":Ljava/util/List;, "Ljava/util/List<Landroid/content/pm/ResolveInfo;>;"
    if-eqz v6, :cond_0

    invoke-interface {v6}, Ljava/util/List;->size()I

    move-result v3

    .line 531
    .local v3, "N":I
    :cond_0
    and-int/lit8 v7, p7, 0x1

    if-nez v7, :cond_1

    .line 532
    invoke-virtual/range {p0 .. p1}, Landroid/support/v7/view/menu/l;->removeGroup(I)V

    .line 535
    :cond_1
    const/4 v7, 0x0

    .local v7, "i":I
    :goto_0
    if-ge v7, v3, :cond_4

    .line 536
    invoke-interface {v6, v7}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Landroid/content/pm/ResolveInfo;

    .line 537
    .local v8, "ri":Landroid/content/pm/ResolveInfo;
    new-instance v9, Landroid/content/Intent;

    iget v10, v8, Landroid/content/pm/ResolveInfo;->specificIndex:I

    if-gez v10, :cond_2

    move-object v10, v5

    goto :goto_1

    :cond_2
    aget-object v10, v1, v10

    :goto_1
    invoke-direct {v9, v10}, Landroid/content/Intent;-><init>(Landroid/content/Intent;)V

    .line 539
    .local v9, "rintent":Landroid/content/Intent;
    new-instance v10, Landroid/content/ComponentName;

    iget-object v11, v8, Landroid/content/pm/ResolveInfo;->activityInfo:Landroid/content/pm/ActivityInfo;

    iget-object v11, v11, Landroid/content/pm/ActivityInfo;->applicationInfo:Landroid/content/pm/ApplicationInfo;

    iget-object v11, v11, Landroid/content/pm/ApplicationInfo;->packageName:Ljava/lang/String;

    iget-object v12, v8, Landroid/content/pm/ResolveInfo;->activityInfo:Landroid/content/pm/ActivityInfo;

    iget-object v12, v12, Landroid/content/pm/ActivityInfo;->name:Ljava/lang/String;

    invoke-direct {v10, v11, v12}, Landroid/content/ComponentName;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {v9, v10}, Landroid/content/Intent;->setComponent(Landroid/content/ComponentName;)Landroid/content/Intent;

    .line 542
    invoke-virtual {v8, v2}, Landroid/content/pm/ResolveInfo;->loadLabel(Landroid/content/pm/PackageManager;)Ljava/lang/CharSequence;

    move-result-object v10

    move/from16 v11, p1

    move/from16 v12, p2

    move/from16 v13, p3

    invoke-virtual {p0, v11, v12, v13, v10}, Landroid/support/v7/view/menu/l;->add(IIILjava/lang/CharSequence;)Landroid/view/MenuItem;

    move-result-object v10

    .line 543
    invoke-virtual {v8, v2}, Landroid/content/pm/ResolveInfo;->loadIcon(Landroid/content/pm/PackageManager;)Landroid/graphics/drawable/Drawable;

    move-result-object v14

    invoke-interface {v10, v14}, Landroid/view/MenuItem;->setIcon(Landroid/graphics/drawable/Drawable;)Landroid/view/MenuItem;

    move-result-object v10

    .line 544
    invoke-interface {v10, v9}, Landroid/view/MenuItem;->setIntent(Landroid/content/Intent;)Landroid/view/MenuItem;

    move-result-object v10

    .line 545
    .local v10, "item":Landroid/view/MenuItem;
    if-eqz p8, :cond_3

    iget v14, v8, Landroid/content/pm/ResolveInfo;->specificIndex:I

    if-ltz v14, :cond_3

    .line 546
    aput-object v10, p8, v14

    .line 535
    .end local v8    # "ri":Landroid/content/pm/ResolveInfo;
    .end local v9    # "rintent":Landroid/content/Intent;
    .end local v10    # "item":Landroid/view/MenuItem;
    :cond_3
    add-int/lit8 v7, v7, 0x1

    goto :goto_0

    :cond_4
    move/from16 v11, p1

    move/from16 v12, p2

    move/from16 v13, p3

    .line 550
    .end local v7    # "i":I
    return v3
.end method

.method public addSubMenu(I)Landroid/view/SubMenu;
    .locals 2
    .param p1, "titleRes"    # I

    .line 497
    iget-object v0, p0, Landroid/support/v7/view/menu/l;->c:Landroid/content/res/Resources;

    invoke-virtual {v0, p1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {p0, v1, v1, v1, v0}, Landroid/support/v7/view/menu/l;->addSubMenu(IIILjava/lang/CharSequence;)Landroid/view/SubMenu;

    move-result-object v0

    return-object v0
.end method

.method public addSubMenu(IIII)Landroid/view/SubMenu;
    .locals 1
    .param p1, "group"    # I
    .param p2, "id"    # I
    .param p3, "categoryOrder"    # I
    .param p4, "title"    # I

    .line 511
    iget-object v0, p0, Landroid/support/v7/view/menu/l;->c:Landroid/content/res/Resources;

    invoke-virtual {v0, p4}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, p1, p2, p3, v0}, Landroid/support/v7/view/menu/l;->addSubMenu(IIILjava/lang/CharSequence;)Landroid/view/SubMenu;

    move-result-object v0

    return-object v0
.end method

.method public addSubMenu(IIILjava/lang/CharSequence;)Landroid/view/SubMenu;
    .locals 3
    .param p1, "group"    # I
    .param p2, "id"    # I
    .param p3, "categoryOrder"    # I
    .param p4, "title"    # Ljava/lang/CharSequence;

    .line 502
    invoke-virtual {p0, p1, p2, p3, p4}, Landroid/support/v7/view/menu/l;->a(IIILjava/lang/CharSequence;)Landroid/view/MenuItem;

    move-result-object v0

    check-cast v0, Landroid/support/v7/view/menu/p;

    .line 503
    .local v0, "item":Landroid/support/v7/view/menu/p;
    new-instance v1, Landroid/support/v7/view/menu/D;

    iget-object v2, p0, Landroid/support/v7/view/menu/l;->b:Landroid/content/Context;

    invoke-direct {v1, v2, p0, v0}, Landroid/support/v7/view/menu/D;-><init>(Landroid/content/Context;Landroid/support/v7/view/menu/l;Landroid/support/v7/view/menu/p;)V

    .line 504
    .local v1, "subMenu":Landroid/support/v7/view/menu/D;
    invoke-virtual {v0, v1}, Landroid/support/v7/view/menu/p;->a(Landroid/support/v7/view/menu/D;)V

    .line 506
    return-object v1
.end method

.method public addSubMenu(Ljava/lang/CharSequence;)Landroid/view/SubMenu;
    .locals 1
    .param p1, "title"    # Ljava/lang/CharSequence;

    .line 492
    const/4 v0, 0x0

    invoke-virtual {p0, v0, v0, v0, p1}, Landroid/support/v7/view/menu/l;->addSubMenu(IIILjava/lang/CharSequence;)Landroid/view/SubMenu;

    move-result-object v0

    return-object v0
.end method

.method public b(I)I
    .locals 4
    .param p1, "id"    # I

    .line 717
    invoke-virtual {p0}, Landroid/support/v7/view/menu/l;->size()I

    move-result v0

    .line 719
    .local v0, "size":I
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    if-ge v1, v0, :cond_1

    .line 720
    iget-object v2, p0, Landroid/support/v7/view/menu/l;->g:Ljava/util/ArrayList;

    invoke-virtual {v2, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroid/support/v7/view/menu/p;

    .line 721
    .local v2, "item":Landroid/support/v7/view/menu/p;
    invoke-virtual {v2}, Landroid/support/v7/view/menu/p;->getItemId()I

    move-result v3

    if-ne v3, p1, :cond_0

    .line 722
    return v1

    .line 719
    .end local v2    # "item":Landroid/support/v7/view/menu/p;
    :cond_0
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 726
    .end local v1    # "i":I
    :cond_1
    const/4 v1, -0x1

    return v1
.end method

.method public b()V
    .locals 6

    .line 1169
    invoke-virtual {p0}, Landroid/support/v7/view/menu/l;->n()Ljava/util/ArrayList;

    move-result-object v0

    .line 1171
    .local v0, "visibleItems":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/support/v7/view/menu/MenuItemImpl;>;"
    iget-boolean v1, p0, Landroid/support/v7/view/menu/l;->l:Z

    if-nez v1, :cond_0

    .line 1172
    return-void

    .line 1176
    :cond_0
    const/4 v1, 0x0

    .line 1177
    .local v1, "flagged":Z
    iget-object v2, p0, Landroid/support/v7/view/menu/l;->x:Ljava/util/concurrent/CopyOnWriteArrayList;

    invoke-virtual {v2}, Ljava/util/concurrent/CopyOnWriteArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_2

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/ref/WeakReference;

    .line 1178
    .local v3, "ref":Ljava/lang/ref/WeakReference;, "Ljava/lang/ref/WeakReference<Landroid/support/v7/view/menu/MenuPresenter;>;"
    invoke-virtual {v3}, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Landroid/support/v7/view/menu/v;

    .line 1179
    .local v4, "presenter":Landroid/support/v7/view/menu/v;
    if-nez v4, :cond_1

    .line 1180
    iget-object v5, p0, Landroid/support/v7/view/menu/l;->x:Ljava/util/concurrent/CopyOnWriteArrayList;

    invoke-virtual {v5, v3}, Ljava/util/concurrent/CopyOnWriteArrayList;->remove(Ljava/lang/Object;)Z

    goto :goto_1

    .line 1182
    :cond_1
    invoke-interface {v4}, Landroid/support/v7/view/menu/v;->a()Z

    move-result v5

    or-int/2addr v1, v5

    .line 1184
    .end local v3    # "ref":Ljava/lang/ref/WeakReference;, "Ljava/lang/ref/WeakReference<Landroid/support/v7/view/menu/MenuPresenter;>;"
    .end local v4    # "presenter":Landroid/support/v7/view/menu/v;
    :goto_1
    goto :goto_0

    .line 1186
    :cond_2
    if-eqz v1, :cond_5

    .line 1187
    iget-object v2, p0, Landroid/support/v7/view/menu/l;->j:Ljava/util/ArrayList;

    invoke-virtual {v2}, Ljava/util/ArrayList;->clear()V

    .line 1188
    iget-object v2, p0, Landroid/support/v7/view/menu/l;->k:Ljava/util/ArrayList;

    invoke-virtual {v2}, Ljava/util/ArrayList;->clear()V

    .line 1189
    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v2

    .line 1190
    .local v2, "itemsSize":I
    const/4 v3, 0x0

    .local v3, "i":I
    :goto_2
    if-ge v3, v2, :cond_4

    .line 1191
    invoke-virtual {v0, v3}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Landroid/support/v7/view/menu/p;

    .line 1192
    .local v4, "item":Landroid/support/v7/view/menu/p;
    invoke-virtual {v4}, Landroid/support/v7/view/menu/p;->h()Z

    move-result v5

    if-eqz v5, :cond_3

    .line 1193
    iget-object v5, p0, Landroid/support/v7/view/menu/l;->j:Ljava/util/ArrayList;

    invoke-virtual {v5, v4}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_3

    .line 1195
    :cond_3
    iget-object v5, p0, Landroid/support/v7/view/menu/l;->k:Ljava/util/ArrayList;

    invoke-virtual {v5, v4}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 1190
    .end local v4    # "item":Landroid/support/v7/view/menu/p;
    :goto_3
    add-int/lit8 v3, v3, 0x1

    goto :goto_2

    .line 1198
    .end local v2    # "itemsSize":I
    .end local v3    # "i":I
    :cond_4
    goto :goto_4

    .line 1201
    :cond_5
    iget-object v2, p0, Landroid/support/v7/view/menu/l;->j:Ljava/util/ArrayList;

    invoke-virtual {v2}, Ljava/util/ArrayList;->clear()V

    .line 1202
    iget-object v2, p0, Landroid/support/v7/view/menu/l;->k:Ljava/util/ArrayList;

    invoke-virtual {v2}, Ljava/util/ArrayList;->clear()V

    .line 1203
    iget-object v2, p0, Landroid/support/v7/view/menu/l;->k:Ljava/util/ArrayList;

    invoke-virtual {p0}, Landroid/support/v7/view/menu/l;->n()Ljava/util/ArrayList;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/util/ArrayList;->addAll(Ljava/util/Collection;)Z

    .line 1205
    :goto_4
    const/4 v2, 0x0

    iput-boolean v2, p0, Landroid/support/v7/view/menu/l;->l:Z

    .line 1206
    return-void
.end method

.method public b(Landroid/os/Bundle;)V
    .locals 7
    .param p1, "outStates"    # Landroid/os/Bundle;

    .line 379
    const/4 v0, 0x0

    .line 381
    .local v0, "viewStates":Landroid/util/SparseArray;, "Landroid/util/SparseArray<Landroid/os/Parcelable;>;"
    invoke-virtual {p0}, Landroid/support/v7/view/menu/l;->size()I

    move-result v1

    .line 382
    .local v1, "itemCount":I
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_0
    if-ge v2, v1, :cond_3

    .line 383
    invoke-virtual {p0, v2}, Landroid/support/v7/view/menu/l;->getItem(I)Landroid/view/MenuItem;

    move-result-object v3

    .line 384
    .local v3, "item":Landroid/view/MenuItem;
    invoke-interface {v3}, Landroid/view/MenuItem;->getActionView()Landroid/view/View;

    move-result-object v4

    .line 385
    .local v4, "v":Landroid/view/View;
    if-eqz v4, :cond_1

    invoke-virtual {v4}, Landroid/view/View;->getId()I

    move-result v5

    const/4 v6, -0x1

    if-eq v5, v6, :cond_1

    .line 386
    if-nez v0, :cond_0

    .line 387
    new-instance v5, Landroid/util/SparseArray;

    invoke-direct {v5}, Landroid/util/SparseArray;-><init>()V

    move-object v0, v5

    .line 389
    :cond_0
    invoke-virtual {v4, v0}, Landroid/view/View;->saveHierarchyState(Landroid/util/SparseArray;)V

    .line 390
    invoke-interface {v3}, Landroid/view/MenuItem;->isActionViewExpanded()Z

    move-result v5

    if-eqz v5, :cond_1

    .line 391
    invoke-interface {v3}, Landroid/view/MenuItem;->getItemId()I

    move-result v5

    const-string v6, "android:menu:expandedactionview"

    invoke-virtual {p1, v6, v5}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 394
    :cond_1
    invoke-interface {v3}, Landroid/view/MenuItem;->hasSubMenu()Z

    move-result v5

    if-eqz v5, :cond_2

    .line 395
    invoke-interface {v3}, Landroid/view/MenuItem;->getSubMenu()Landroid/view/SubMenu;

    move-result-object v5

    check-cast v5, Landroid/support/v7/view/menu/D;

    .line 396
    .local v5, "subMenu":Landroid/support/v7/view/menu/D;
    invoke-virtual {v5, p1}, Landroid/support/v7/view/menu/l;->b(Landroid/os/Bundle;)V

    .line 382
    .end local v3    # "item":Landroid/view/MenuItem;
    .end local v4    # "v":Landroid/view/View;
    .end local v5    # "subMenu":Landroid/support/v7/view/menu/D;
    :cond_2
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 400
    .end local v2    # "i":I
    :cond_3
    if-eqz v0, :cond_4

    .line 401
    invoke-virtual {p0}, Landroid/support/v7/view/menu/l;->d()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p1, v2, v0}, Landroid/os/Bundle;->putSparseParcelableArray(Ljava/lang/String;Landroid/util/SparseArray;)V

    .line 403
    :cond_4
    return-void
.end method

.method public b(Landroid/support/v7/view/menu/v;)V
    .locals 4
    .param p1, "presenter"    # Landroid/support/v7/view/menu/v;

    .line 281
    iget-object v0, p0, Landroid/support/v7/view/menu/l;->x:Ljava/util/concurrent/CopyOnWriteArrayList;

    invoke-virtual {v0}, Ljava/util/concurrent/CopyOnWriteArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_2

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/ref/WeakReference;

    .line 282
    .local v1, "ref":Ljava/lang/ref/WeakReference;, "Ljava/lang/ref/WeakReference<Landroid/support/v7/view/menu/MenuPresenter;>;"
    invoke-virtual {v1}, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroid/support/v7/view/menu/v;

    .line 283
    .local v2, "item":Landroid/support/v7/view/menu/v;
    if-eqz v2, :cond_0

    if-ne v2, p1, :cond_1

    .line 284
    :cond_0
    iget-object v3, p0, Landroid/support/v7/view/menu/l;->x:Ljava/util/concurrent/CopyOnWriteArrayList;

    invoke-virtual {v3, v1}, Ljava/util/concurrent/CopyOnWriteArrayList;->remove(Ljava/lang/Object;)Z

    .line 286
    .end local v1    # "ref":Ljava/lang/ref/WeakReference;, "Ljava/lang/ref/WeakReference<Landroid/support/v7/view/menu/MenuPresenter;>;"
    .end local v2    # "item":Landroid/support/v7/view/menu/v;
    :cond_1
    goto :goto_0

    .line 287
    :cond_2
    return-void
.end method

.method public b(Z)V
    .locals 2
    .param p1, "structureChanged"    # Z

    .line 1063
    iget-boolean v0, p0, Landroid/support/v7/view/menu/l;->r:Z

    const/4 v1, 0x1

    if-nez v0, :cond_1

    .line 1064
    if-eqz p1, :cond_0

    .line 1065
    iput-boolean v1, p0, Landroid/support/v7/view/menu/l;->i:Z

    .line 1066
    iput-boolean v1, p0, Landroid/support/v7/view/menu/l;->l:Z

    .line 1069
    :cond_0
    invoke-direct {p0, p1}, Landroid/support/v7/view/menu/l;->d(Z)V

    goto :goto_0

    .line 1071
    :cond_1
    iput-boolean v1, p0, Landroid/support/v7/view/menu/l;->s:Z

    .line 1072
    if-eqz p1, :cond_2

    .line 1073
    iput-boolean v1, p0, Landroid/support/v7/view/menu/l;->t:Z

    .line 1076
    :cond_2
    :goto_0
    return-void
.end method

.method public b(Landroid/support/v7/view/menu/p;)Z
    .locals 5
    .param p1, "item"    # Landroid/support/v7/view/menu/p;

    .line 1357
    iget-object v0, p0, Landroid/support/v7/view/menu/l;->x:Ljava/util/concurrent/CopyOnWriteArrayList;

    invoke-virtual {v0}, Ljava/util/concurrent/CopyOnWriteArrayList;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x0

    return v0

    .line 1359
    :cond_0
    const/4 v0, 0x0

    .line 1361
    .local v0, "expanded":Z
    invoke-virtual {p0}, Landroid/support/v7/view/menu/l;->s()V

    .line 1362
    iget-object v1, p0, Landroid/support/v7/view/menu/l;->x:Ljava/util/concurrent/CopyOnWriteArrayList;

    invoke-virtual {v1}, Ljava/util/concurrent/CopyOnWriteArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_3

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/ref/WeakReference;

    .line 1363
    .local v2, "ref":Ljava/lang/ref/WeakReference;, "Ljava/lang/ref/WeakReference<Landroid/support/v7/view/menu/MenuPresenter;>;"
    invoke-virtual {v2}, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Landroid/support/v7/view/menu/v;

    .line 1364
    .local v3, "presenter":Landroid/support/v7/view/menu/v;
    if-nez v3, :cond_1

    .line 1365
    iget-object v4, p0, Landroid/support/v7/view/menu/l;->x:Ljava/util/concurrent/CopyOnWriteArrayList;

    invoke-virtual {v4, v2}, Ljava/util/concurrent/CopyOnWriteArrayList;->remove(Ljava/lang/Object;)Z

    goto :goto_1

    .line 1366
    :cond_1
    invoke-interface {v3, p0, p1}, Landroid/support/v7/view/menu/v;->a(Landroid/support/v7/view/menu/l;Landroid/support/v7/view/menu/p;)Z

    move-result v4

    move v0, v4

    if-eqz v4, :cond_2

    .line 1367
    goto :goto_2

    .line 1369
    .end local v2    # "ref":Ljava/lang/ref/WeakReference;, "Ljava/lang/ref/WeakReference<Landroid/support/v7/view/menu/MenuPresenter;>;"
    .end local v3    # "presenter":Landroid/support/v7/view/menu/v;
    :cond_2
    :goto_1
    goto :goto_0

    .line 1370
    :cond_3
    :goto_2
    invoke-virtual {p0}, Landroid/support/v7/view/menu/l;->r()V

    .line 1372
    if-eqz v0, :cond_4

    .line 1373
    iput-object p1, p0, Landroid/support/v7/view/menu/l;->y:Landroid/support/v7/view/menu/p;

    .line 1375
    :cond_4
    return v0
.end method

.method public c(I)Landroid/support/v7/view/menu/l;
    .locals 0
    .param p1, "defaultShowAsAction"    # I

    .line 245
    iput p1, p0, Landroid/support/v7/view/menu/l;->m:I

    .line 246
    return-object p0
.end method

.method public c()Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList<",
            "Landroid/support/v7/view/menu/p;",
            ">;"
        }
    .end annotation

    .line 1209
    invoke-virtual {p0}, Landroid/support/v7/view/menu/l;->b()V

    .line 1210
    iget-object v0, p0, Landroid/support/v7/view/menu/l;->j:Ljava/util/ArrayList;

    return-object v0
.end method

.method c(Landroid/support/v7/view/menu/p;)V
    .locals 1
    .param p1, "item"    # Landroid/support/v7/view/menu/p;

    .line 1118
    const/4 v0, 0x1

    iput-boolean v0, p0, Landroid/support/v7/view/menu/l;->l:Z

    .line 1119
    invoke-virtual {p0, v0}, Landroid/support/v7/view/menu/l;->b(Z)V

    .line 1120
    return-void
.end method

.method public c(Z)V
    .locals 0
    .param p1, "override"    # Z

    .line 1410
    iput-boolean p1, p0, Landroid/support/v7/view/menu/l;->A:Z

    .line 1411
    return-void
.end method

.method public clear()V
    .locals 1

    .line 610
    iget-object v0, p0, Landroid/support/v7/view/menu/l;->y:Landroid/support/v7/view/menu/p;

    if-eqz v0, :cond_0

    .line 611
    invoke-virtual {p0, v0}, Landroid/support/v7/view/menu/l;->a(Landroid/support/v7/view/menu/p;)Z

    .line 613
    :cond_0
    iget-object v0, p0, Landroid/support/v7/view/menu/l;->g:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->clear()V

    .line 615
    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Landroid/support/v7/view/menu/l;->b(Z)V

    .line 616
    return-void
.end method

.method public clearHeader()V
    .locals 1

    .line 1219
    const/4 v0, 0x0

    iput-object v0, p0, Landroid/support/v7/view/menu/l;->p:Landroid/graphics/drawable/Drawable;

    .line 1220
    iput-object v0, p0, Landroid/support/v7/view/menu/l;->o:Ljava/lang/CharSequence;

    .line 1221
    iput-object v0, p0, Landroid/support/v7/view/menu/l;->q:Landroid/view/View;

    .line 1223
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Landroid/support/v7/view/menu/l;->b(Z)V

    .line 1224
    return-void
.end method

.method public close()V
    .locals 1

    .line 1052
    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Landroid/support/v7/view/menu/l;->a(Z)V

    .line 1053
    return-void
.end method

.method protected d(I)Landroid/support/v7/view/menu/l;
    .locals 6
    .param p1, "iconRes"    # I

    .line 1301
    const/4 v1, 0x0

    const/4 v2, 0x0

    const/4 v4, 0x0

    const/4 v5, 0x0

    move-object v0, p0

    move v3, p1

    invoke-direct/range {v0 .. v5}, Landroid/support/v7/view/menu/l;->a(ILjava/lang/CharSequence;ILandroid/graphics/drawable/Drawable;Landroid/view/View;)V

    .line 1302
    return-object p0
.end method

.method protected d()Ljava/lang/String;
    .locals 1

    .line 436
    const-string v0, "android:menu:actionviewstates"

    return-object v0
.end method

.method d(Landroid/support/v7/view/menu/p;)V
    .locals 1
    .param p1, "item"    # Landroid/support/v7/view/menu/p;

    .line 1107
    const/4 v0, 0x1

    iput-boolean v0, p0, Landroid/support/v7/view/menu/l;->i:Z

    .line 1108
    invoke-virtual {p0, v0}, Landroid/support/v7/view/menu/l;->b(Z)V

    .line 1109
    return-void
.end method

.method public e()Landroid/content/Context;
    .locals 1

    .line 836
    iget-object v0, p0, Landroid/support/v7/view/menu/l;->b:Landroid/content/Context;

    return-object v0
.end method

.method protected e(I)Landroid/support/v7/view/menu/l;
    .locals 6
    .param p1, "titleRes"    # I

    .line 1277
    const/4 v2, 0x0

    const/4 v3, 0x0

    const/4 v4, 0x0

    const/4 v5, 0x0

    move-object v0, p0

    move v1, p1

    invoke-direct/range {v0 .. v5}, Landroid/support/v7/view/menu/l;->a(ILjava/lang/CharSequence;ILandroid/graphics/drawable/Drawable;Landroid/view/View;)V

    .line 1278
    return-object p0
.end method

.method public f()Landroid/support/v7/view/menu/p;
    .locals 1

    .line 1401
    iget-object v0, p0, Landroid/support/v7/view/menu/l;->y:Landroid/support/v7/view/menu/p;

    return-object v0
.end method

.method public findItem(I)Landroid/view/MenuItem;
    .locals 4
    .param p1, "id"    # I

    .line 699
    invoke-virtual {p0}, Landroid/support/v7/view/menu/l;->size()I

    move-result v0

    .line 700
    .local v0, "size":I
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    if-ge v1, v0, :cond_2

    .line 701
    iget-object v2, p0, Landroid/support/v7/view/menu/l;->g:Ljava/util/ArrayList;

    invoke-virtual {v2, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroid/support/v7/view/menu/p;

    .line 702
    .local v2, "item":Landroid/support/v7/view/menu/p;
    invoke-virtual {v2}, Landroid/support/v7/view/menu/p;->getItemId()I

    move-result v3

    if-ne v3, p1, :cond_0

    .line 703
    return-object v2

    .line 704
    :cond_0
    invoke-virtual {v2}, Landroid/support/v7/view/menu/p;->hasSubMenu()Z

    move-result v3

    if-eqz v3, :cond_1

    .line 705
    invoke-virtual {v2}, Landroid/support/v7/view/menu/p;->getSubMenu()Landroid/view/SubMenu;

    move-result-object v3

    invoke-interface {v3, p1}, Landroid/view/SubMenu;->findItem(I)Landroid/view/MenuItem;

    move-result-object v3

    .line 707
    .local v3, "possibleItem":Landroid/view/MenuItem;
    if-eqz v3, :cond_1

    .line 708
    return-object v3

    .line 700
    .end local v2    # "item":Landroid/support/v7/view/menu/p;
    .end local v3    # "possibleItem":Landroid/view/MenuItem;
    :cond_1
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 713
    .end local v1    # "i":I
    :cond_2
    const/4 v1, 0x0

    return-object v1
.end method

.method public g()Landroid/graphics/drawable/Drawable;
    .locals 1

    .line 1322
    iget-object v0, p0, Landroid/support/v7/view/menu/l;->p:Landroid/graphics/drawable/Drawable;

    return-object v0
.end method

.method public getItem(I)Landroid/view/MenuItem;
    .locals 1
    .param p1, "index"    # I

    .line 758
    iget-object v0, p0, Landroid/support/v7/view/menu/l;->g:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/MenuItem;

    return-object v0
.end method

.method public h()Ljava/lang/CharSequence;
    .locals 1

    .line 1318
    iget-object v0, p0, Landroid/support/v7/view/menu/l;->o:Ljava/lang/CharSequence;

    return-object v0
.end method

.method public hasVisibleItems()Z
    .locals 5

    .line 681
    iget-boolean v0, p0, Landroid/support/v7/view/menu/l;->A:Z

    const/4 v1, 0x1

    if-eqz v0, :cond_0

    .line 682
    return v1

    .line 685
    :cond_0
    invoke-virtual {p0}, Landroid/support/v7/view/menu/l;->size()I

    move-result v0

    .line 687
    .local v0, "size":I
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_0
    if-ge v2, v0, :cond_2

    .line 688
    iget-object v3, p0, Landroid/support/v7/view/menu/l;->g:Ljava/util/ArrayList;

    invoke-virtual {v3, v2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Landroid/support/v7/view/menu/p;

    .line 689
    .local v3, "item":Landroid/support/v7/view/menu/p;
    invoke-virtual {v3}, Landroid/support/v7/view/menu/p;->isVisible()Z

    move-result v4

    if-eqz v4, :cond_1

    .line 690
    return v1

    .line 687
    .end local v3    # "item":Landroid/support/v7/view/menu/p;
    :cond_1
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 694
    .end local v2    # "i":I
    :cond_2
    const/4 v1, 0x0

    return v1
.end method

.method public i()Landroid/view/View;
    .locals 1

    .line 1326
    iget-object v0, p0, Landroid/support/v7/view/menu/l;->q:Landroid/view/View;

    return-object v0
.end method

.method public isShortcutKey(ILandroid/view/KeyEvent;)Z
    .locals 1
    .param p1, "keyCode"    # I
    .param p2, "event"    # Landroid/view/KeyEvent;

    .line 763
    invoke-virtual {p0, p1, p2}, Landroid/support/v7/view/menu/l;->a(ILandroid/view/KeyEvent;)Landroid/support/v7/view/menu/p;

    move-result-object v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    :goto_0
    return v0
.end method

.method public j()Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList<",
            "Landroid/support/v7/view/menu/p;",
            ">;"
        }
    .end annotation

    .line 1214
    invoke-virtual {p0}, Landroid/support/v7/view/menu/l;->b()V

    .line 1215
    iget-object v0, p0, Landroid/support/v7/view/menu/l;->k:Ljava/util/ArrayList;

    return-object v0
.end method

.method k()Z
    .locals 1

    .line 1353
    iget-boolean v0, p0, Landroid/support/v7/view/menu/l;->u:Z

    return v0
.end method

.method l()Landroid/content/res/Resources;
    .locals 1

    .line 832
    iget-object v0, p0, Landroid/support/v7/view/menu/l;->c:Landroid/content/res/Resources;

    return-object v0
.end method

.method public m()Landroid/support/v7/view/menu/l;
    .locals 0

    .line 1334
    return-object p0
.end method

.method public n()Ljava/util/ArrayList;
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList<",
            "Landroid/support/v7/view/menu/p;",
            ">;"
        }
    .end annotation

    .line 1124
    iget-boolean v0, p0, Landroid/support/v7/view/menu/l;->i:Z

    if-nez v0, :cond_0

    iget-object v0, p0, Landroid/support/v7/view/menu/l;->h:Ljava/util/ArrayList;

    return-object v0

    .line 1127
    :cond_0
    iget-object v0, p0, Landroid/support/v7/view/menu/l;->h:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->clear()V

    .line 1129
    iget-object v0, p0, Landroid/support/v7/view/menu/l;->g:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    .line 1131
    .local v0, "itemsSize":I
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    if-ge v1, v0, :cond_2

    .line 1132
    iget-object v2, p0, Landroid/support/v7/view/menu/l;->g:Ljava/util/ArrayList;

    invoke-virtual {v2, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroid/support/v7/view/menu/p;

    .line 1133
    .local v2, "item":Landroid/support/v7/view/menu/p;
    invoke-virtual {v2}, Landroid/support/v7/view/menu/p;->isVisible()Z

    move-result v3

    if-eqz v3, :cond_1

    iget-object v3, p0, Landroid/support/v7/view/menu/l;->h:Ljava/util/ArrayList;

    invoke-virtual {v3, v2}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 1131
    :cond_1
    nop

    .end local v2    # "item":Landroid/support/v7/view/menu/p;
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 1136
    .end local v1    # "i":I
    :cond_2
    const/4 v1, 0x0

    iput-boolean v1, p0, Landroid/support/v7/view/menu/l;->i:Z

    .line 1137
    const/4 v1, 0x1

    iput-boolean v1, p0, Landroid/support/v7/view/menu/l;->l:Z

    .line 1139
    iget-object v1, p0, Landroid/support/v7/view/menu/l;->h:Ljava/util/ArrayList;

    return-object v1
.end method

.method public o()Z
    .locals 1

    .line 520
    iget-boolean v0, p0, Landroid/support/v7/view/menu/l;->z:Z

    return v0
.end method

.method p()Z
    .locals 1

    .line 798
    iget-boolean v0, p0, Landroid/support/v7/view/menu/l;->d:Z

    return v0
.end method

.method public performIdentifierAction(II)Z
    .locals 1
    .param p1, "id"    # I
    .param p2, "flags"    # I

    .line 977
    invoke-virtual {p0, p1}, Landroid/support/v7/view/menu/l;->findItem(I)Landroid/view/MenuItem;

    move-result-object v0

    invoke-virtual {p0, v0, p2}, Landroid/support/v7/view/menu/l;->a(Landroid/view/MenuItem;I)Z

    move-result v0

    return v0
.end method

.method public performShortcut(ILandroid/view/KeyEvent;I)Z
    .locals 3
    .param p1, "keyCode"    # I
    .param p2, "event"    # Landroid/view/KeyEvent;
    .param p3, "flags"    # I

    .line 865
    invoke-virtual {p0, p1, p2}, Landroid/support/v7/view/menu/l;->a(ILandroid/view/KeyEvent;)Landroid/support/v7/view/menu/p;

    move-result-object v0

    .line 867
    .local v0, "item":Landroid/support/v7/view/menu/p;
    const/4 v1, 0x0

    .line 869
    .local v1, "handled":Z
    if-eqz v0, :cond_0

    .line 870
    invoke-virtual {p0, v0, p3}, Landroid/support/v7/view/menu/l;->a(Landroid/view/MenuItem;I)Z

    move-result v1

    .line 873
    :cond_0
    and-int/lit8 v2, p3, 0x2

    if-eqz v2, :cond_1

    .line 874
    const/4 v2, 0x1

    invoke-virtual {p0, v2}, Landroid/support/v7/view/menu/l;->a(Z)V

    .line 877
    :cond_1
    return v1
.end method

.method public q()Z
    .locals 1

    .line 828
    iget-boolean v0, p0, Landroid/support/v7/view/menu/l;->e:Z

    return v0
.end method

.method public r()V
    .locals 2

    .line 1092
    const/4 v0, 0x0

    iput-boolean v0, p0, Landroid/support/v7/view/menu/l;->r:Z

    .line 1094
    iget-boolean v1, p0, Landroid/support/v7/view/menu/l;->s:Z

    if-eqz v1, :cond_0

    .line 1095
    iput-boolean v0, p0, Landroid/support/v7/view/menu/l;->s:Z

    .line 1096
    iget-boolean v0, p0, Landroid/support/v7/view/menu/l;->t:Z

    invoke-virtual {p0, v0}, Landroid/support/v7/view/menu/l;->b(Z)V

    .line 1098
    :cond_0
    return-void
.end method

.method public removeGroup(I)V
    .locals 4
    .param p1, "group"    # I

    .line 560
    invoke-virtual {p0, p1}, Landroid/support/v7/view/menu/l;->a(I)I

    move-result v0

    .line 562
    .local v0, "i":I
    if-ltz v0, :cond_1

    .line 563
    iget-object v1, p0, Landroid/support/v7/view/menu/l;->g:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v1

    sub-int/2addr v1, v0

    .line 564
    .local v1, "maxRemovable":I
    const/4 v2, 0x0

    .line 565
    .local v2, "numRemoved":I
    :goto_0
    add-int/lit8 v3, v2, 0x1

    .end local v2    # "numRemoved":I
    .local v3, "numRemoved":I
    if-ge v2, v1, :cond_0

    iget-object v2, p0, Landroid/support/v7/view/menu/l;->g:Ljava/util/ArrayList;

    invoke-virtual {v2, v0}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroid/support/v7/view/menu/p;

    invoke-virtual {v2}, Landroid/support/v7/view/menu/p;->getGroupId()I

    move-result v2

    if-ne v2, p1, :cond_0

    .line 567
    const/4 v2, 0x0

    invoke-direct {p0, v0, v2}, Landroid/support/v7/view/menu/l;->a(IZ)V

    move v2, v3

    goto :goto_0

    .line 571
    :cond_0
    const/4 v2, 0x1

    invoke-virtual {p0, v2}, Landroid/support/v7/view/menu/l;->b(Z)V

    .line 573
    .end local v1    # "maxRemovable":I
    .end local v3    # "numRemoved":I
    :cond_1
    return-void
.end method

.method public removeItem(I)V
    .locals 2
    .param p1, "id"    # I

    .line 555
    invoke-virtual {p0, p1}, Landroid/support/v7/view/menu/l;->b(I)I

    move-result v0

    const/4 v1, 0x1

    invoke-direct {p0, v0, v1}, Landroid/support/v7/view/menu/l;->a(IZ)V

    .line 556
    return-void
.end method

.method public s()V
    .locals 1

    .line 1084
    iget-boolean v0, p0, Landroid/support/v7/view/menu/l;->r:Z

    if-nez v0, :cond_0

    .line 1085
    const/4 v0, 0x1

    iput-boolean v0, p0, Landroid/support/v7/view/menu/l;->r:Z

    .line 1086
    const/4 v0, 0x0

    iput-boolean v0, p0, Landroid/support/v7/view/menu/l;->s:Z

    .line 1087
    iput-boolean v0, p0, Landroid/support/v7/view/menu/l;->t:Z

    .line 1089
    :cond_0
    return-void
.end method

.method public setGroupCheckable(IZZ)V
    .locals 4
    .param p1, "group"    # I
    .param p2, "checkable"    # Z
    .param p3, "exclusive"    # Z

    .line 638
    iget-object v0, p0, Landroid/support/v7/view/menu/l;->g:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    .line 640
    .local v0, "N":I
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    if-ge v1, v0, :cond_1

    .line 641
    iget-object v2, p0, Landroid/support/v7/view/menu/l;->g:Ljava/util/ArrayList;

    invoke-virtual {v2, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroid/support/v7/view/menu/p;

    .line 642
    .local v2, "item":Landroid/support/v7/view/menu/p;
    invoke-virtual {v2}, Landroid/support/v7/view/menu/p;->getGroupId()I

    move-result v3

    if-ne v3, p1, :cond_0

    .line 643
    invoke-virtual {v2, p3}, Landroid/support/v7/view/menu/p;->c(Z)V

    .line 644
    invoke-virtual {v2, p2}, Landroid/support/v7/view/menu/p;->setCheckable(Z)Landroid/view/MenuItem;

    .line 640
    .end local v2    # "item":Landroid/support/v7/view/menu/p;
    :cond_0
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 647
    .end local v1    # "i":I
    :cond_1
    return-void
.end method

.method public setGroupDividerEnabled(Z)V
    .locals 0
    .param p1, "enabled"    # Z

    .line 516
    iput-boolean p1, p0, Landroid/support/v7/view/menu/l;->z:Z

    .line 517
    return-void
.end method

.method public setGroupEnabled(IZ)V
    .locals 4
    .param p1, "group"    # I
    .param p2, "enabled"    # Z

    .line 669
    iget-object v0, p0, Landroid/support/v7/view/menu/l;->g:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    .line 671
    .local v0, "N":I
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    if-ge v1, v0, :cond_1

    .line 672
    iget-object v2, p0, Landroid/support/v7/view/menu/l;->g:Ljava/util/ArrayList;

    invoke-virtual {v2, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroid/support/v7/view/menu/p;

    .line 673
    .local v2, "item":Landroid/support/v7/view/menu/p;
    invoke-virtual {v2}, Landroid/support/v7/view/menu/p;->getGroupId()I

    move-result v3

    if-ne v3, p1, :cond_0

    .line 674
    invoke-virtual {v2, p2}, Landroid/support/v7/view/menu/p;->setEnabled(Z)Landroid/view/MenuItem;

    .line 671
    .end local v2    # "item":Landroid/support/v7/view/menu/p;
    :cond_0
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 677
    .end local v1    # "i":I
    :cond_1
    return-void
.end method

.method public setGroupVisible(IZ)V
    .locals 5
    .param p1, "group"    # I
    .param p2, "visible"    # Z

    .line 651
    iget-object v0, p0, Landroid/support/v7/view/menu/l;->g:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    .line 656
    .local v0, "N":I
    const/4 v1, 0x0

    .line 657
    .local v1, "changedAtLeastOneItem":Z
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_0
    if-ge v2, v0, :cond_1

    .line 658
    iget-object v3, p0, Landroid/support/v7/view/menu/l;->g:Ljava/util/ArrayList;

    invoke-virtual {v3, v2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Landroid/support/v7/view/menu/p;

    .line 659
    .local v3, "item":Landroid/support/v7/view/menu/p;
    invoke-virtual {v3}, Landroid/support/v7/view/menu/p;->getGroupId()I

    move-result v4

    if-ne v4, p1, :cond_0

    .line 660
    invoke-virtual {v3, p2}, Landroid/support/v7/view/menu/p;->e(Z)Z

    move-result v4

    if-eqz v4, :cond_0

    const/4 v1, 0x1

    .line 657
    .end local v3    # "item":Landroid/support/v7/view/menu/p;
    :cond_0
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 664
    .end local v2    # "i":I
    :cond_1
    if-eqz v1, :cond_2

    const/4 v2, 0x1

    invoke-virtual {p0, v2}, Landroid/support/v7/view/menu/l;->b(Z)V

    .line 665
    :cond_2
    return-void
.end method

.method public setQwertyMode(Z)V
    .locals 1
    .param p1, "isQwerty"    # Z

    .line 768
    iput-boolean p1, p0, Landroid/support/v7/view/menu/l;->d:Z

    .line 770
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Landroid/support/v7/view/menu/l;->b(Z)V

    .line 771
    return-void
.end method

.method public size()I
    .locals 1

    .line 753
    iget-object v0, p0, Landroid/support/v7/view/menu/l;->g:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    return v0
.end method
