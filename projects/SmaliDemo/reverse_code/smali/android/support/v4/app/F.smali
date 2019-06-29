.class final Landroid/support/v4/app/F;
.super Ljava/lang/Object;
.source ""

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Landroid/support/v4/app/G;->a(Landroid/support/v4/app/P;Landroid/view/ViewGroup;Landroid/view/View;La/b/c/f/b;Landroid/support/v4/app/G$a;Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation


# instance fields
.field final synthetic a:Landroid/support/v4/app/P;

.field final synthetic b:La/b/c/f/b;

.field final synthetic c:Ljava/lang/Object;

.field final synthetic d:Landroid/support/v4/app/G$a;

.field final synthetic e:Ljava/util/ArrayList;

.field final synthetic f:Landroid/view/View;

.field final synthetic g:Landroid/support/v4/app/i;

.field final synthetic h:Landroid/support/v4/app/i;

.field final synthetic i:Z

.field final synthetic j:Ljava/util/ArrayList;

.field final synthetic k:Ljava/lang/Object;

.field final synthetic l:Landroid/graphics/Rect;


# direct methods
.method constructor <init>(Landroid/support/v4/app/P;La/b/c/f/b;Ljava/lang/Object;Landroid/support/v4/app/G$a;Ljava/util/ArrayList;Landroid/view/View;Landroid/support/v4/app/i;Landroid/support/v4/app/i;ZLjava/util/ArrayList;Ljava/lang/Object;Landroid/graphics/Rect;)V
    .locals 0

    .line 734
    iput-object p1, p0, Landroid/support/v4/app/F;->a:Landroid/support/v4/app/P;

    iput-object p2, p0, Landroid/support/v4/app/F;->b:La/b/c/f/b;

    iput-object p3, p0, Landroid/support/v4/app/F;->c:Ljava/lang/Object;

    iput-object p4, p0, Landroid/support/v4/app/F;->d:Landroid/support/v4/app/G$a;

    iput-object p5, p0, Landroid/support/v4/app/F;->e:Ljava/util/ArrayList;

    iput-object p6, p0, Landroid/support/v4/app/F;->f:Landroid/view/View;

    iput-object p7, p0, Landroid/support/v4/app/F;->g:Landroid/support/v4/app/i;

    iput-object p8, p0, Landroid/support/v4/app/F;->h:Landroid/support/v4/app/i;

    iput-boolean p9, p0, Landroid/support/v4/app/F;->i:Z

    iput-object p10, p0, Landroid/support/v4/app/F;->j:Ljava/util/ArrayList;

    iput-object p11, p0, Landroid/support/v4/app/F;->k:Ljava/lang/Object;

    iput-object p12, p0, Landroid/support/v4/app/F;->l:Landroid/graphics/Rect;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 5

    .line 737
    iget-object v0, p0, Landroid/support/v4/app/F;->a:Landroid/support/v4/app/P;

    iget-object v1, p0, Landroid/support/v4/app/F;->b:La/b/c/f/b;

    iget-object v2, p0, Landroid/support/v4/app/F;->c:Ljava/lang/Object;

    iget-object v3, p0, Landroid/support/v4/app/F;->d:Landroid/support/v4/app/G$a;

    invoke-static {v0, v1, v2, v3}, Landroid/support/v4/app/G;->a(Landroid/support/v4/app/P;La/b/c/f/b;Ljava/lang/Object;Landroid/support/v4/app/G$a;)La/b/c/f/b;

    move-result-object v0

    .line 740
    .local v0, "inSharedElements":La/b/c/f/b;, "Landroid/support/v4/util/ArrayMap<Ljava/lang/String;Landroid/view/View;>;"
    if-eqz v0, :cond_0

    .line 741
    iget-object v1, p0, Landroid/support/v4/app/F;->e:Ljava/util/ArrayList;

    invoke-virtual {v0}, La/b/c/f/b;->values()Ljava/util/Collection;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/util/ArrayList;->addAll(Ljava/util/Collection;)Z

    .line 742
    iget-object v1, p0, Landroid/support/v4/app/F;->e:Ljava/util/ArrayList;

    iget-object v2, p0, Landroid/support/v4/app/F;->f:Landroid/view/View;

    invoke-virtual {v1, v2}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 745
    :cond_0
    iget-object v1, p0, Landroid/support/v4/app/F;->g:Landroid/support/v4/app/i;

    iget-object v2, p0, Landroid/support/v4/app/F;->h:Landroid/support/v4/app/i;

    iget-boolean v3, p0, Landroid/support/v4/app/F;->i:Z

    const/4 v4, 0x0

    invoke-static {v1, v2, v3, v0, v4}, Landroid/support/v4/app/G;->a(Landroid/support/v4/app/i;Landroid/support/v4/app/i;ZLa/b/c/f/b;Z)V

    .line 747
    iget-object v1, p0, Landroid/support/v4/app/F;->c:Ljava/lang/Object;

    if-eqz v1, :cond_1

    .line 748
    iget-object v2, p0, Landroid/support/v4/app/F;->a:Landroid/support/v4/app/P;

    iget-object v3, p0, Landroid/support/v4/app/F;->j:Ljava/util/ArrayList;

    iget-object v4, p0, Landroid/support/v4/app/F;->e:Ljava/util/ArrayList;

    invoke-virtual {v2, v1, v3, v4}, Landroid/support/v4/app/P;->b(Ljava/lang/Object;Ljava/util/ArrayList;Ljava/util/ArrayList;)V

    .line 752
    iget-object v1, p0, Landroid/support/v4/app/F;->d:Landroid/support/v4/app/G$a;

    iget-object v2, p0, Landroid/support/v4/app/F;->k:Ljava/lang/Object;

    iget-boolean v3, p0, Landroid/support/v4/app/F;->i:Z

    invoke-static {v0, v1, v2, v3}, Landroid/support/v4/app/G;->a(La/b/c/f/b;Landroid/support/v4/app/G$a;Ljava/lang/Object;Z)Landroid/view/View;

    move-result-object v1

    .line 754
    .local v1, "inEpicenterView":Landroid/view/View;
    if-eqz v1, :cond_1

    .line 755
    iget-object v2, p0, Landroid/support/v4/app/F;->a:Landroid/support/v4/app/P;

    iget-object v3, p0, Landroid/support/v4/app/F;->l:Landroid/graphics/Rect;

    invoke-virtual {v2, v1, v3}, Landroid/support/v4/app/P;->a(Landroid/view/View;Landroid/graphics/Rect;)V

    .line 759
    .end local v1    # "inEpicenterView":Landroid/view/View;
    :cond_1
    return-void
.end method
