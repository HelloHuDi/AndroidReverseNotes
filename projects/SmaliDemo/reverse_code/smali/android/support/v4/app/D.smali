.class final Landroid/support/v4/app/D;
.super Ljava/lang/Object;
.source ""

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Landroid/support/v4/app/G;->a(Landroid/support/v4/app/P;Landroid/view/ViewGroup;Landroid/support/v4/app/i;Landroid/view/View;Ljava/util/ArrayList;Ljava/lang/Object;Ljava/util/ArrayList;Ljava/lang/Object;Ljava/util/ArrayList;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation


# instance fields
.field final synthetic a:Ljava/lang/Object;

.field final synthetic b:Landroid/support/v4/app/P;

.field final synthetic c:Landroid/view/View;

.field final synthetic d:Landroid/support/v4/app/i;

.field final synthetic e:Ljava/util/ArrayList;

.field final synthetic f:Ljava/util/ArrayList;

.field final synthetic g:Ljava/util/ArrayList;

.field final synthetic h:Ljava/lang/Object;


# direct methods
.method constructor <init>(Ljava/lang/Object;Landroid/support/v4/app/P;Landroid/view/View;Landroid/support/v4/app/i;Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/lang/Object;)V
    .locals 0

    .line 392
    iput-object p1, p0, Landroid/support/v4/app/D;->a:Ljava/lang/Object;

    iput-object p2, p0, Landroid/support/v4/app/D;->b:Landroid/support/v4/app/P;

    iput-object p3, p0, Landroid/support/v4/app/D;->c:Landroid/view/View;

    iput-object p4, p0, Landroid/support/v4/app/D;->d:Landroid/support/v4/app/i;

    iput-object p5, p0, Landroid/support/v4/app/D;->e:Ljava/util/ArrayList;

    iput-object p6, p0, Landroid/support/v4/app/D;->f:Ljava/util/ArrayList;

    iput-object p7, p0, Landroid/support/v4/app/D;->g:Ljava/util/ArrayList;

    iput-object p8, p0, Landroid/support/v4/app/D;->h:Ljava/lang/Object;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 5

    .line 395
    iget-object v0, p0, Landroid/support/v4/app/D;->a:Ljava/lang/Object;

    if-eqz v0, :cond_0

    .line 396
    iget-object v1, p0, Landroid/support/v4/app/D;->b:Landroid/support/v4/app/P;

    iget-object v2, p0, Landroid/support/v4/app/D;->c:Landroid/view/View;

    invoke-virtual {v1, v0, v2}, Landroid/support/v4/app/P;->b(Ljava/lang/Object;Landroid/view/View;)V

    .line 398
    iget-object v0, p0, Landroid/support/v4/app/D;->b:Landroid/support/v4/app/P;

    iget-object v1, p0, Landroid/support/v4/app/D;->a:Ljava/lang/Object;

    iget-object v2, p0, Landroid/support/v4/app/D;->d:Landroid/support/v4/app/i;

    iget-object v3, p0, Landroid/support/v4/app/D;->e:Ljava/util/ArrayList;

    iget-object v4, p0, Landroid/support/v4/app/D;->c:Landroid/view/View;

    invoke-static {v0, v1, v2, v3, v4}, Landroid/support/v4/app/G;->a(Landroid/support/v4/app/P;Ljava/lang/Object;Landroid/support/v4/app/i;Ljava/util/ArrayList;Landroid/view/View;)Ljava/util/ArrayList;

    move-result-object v0

    .line 400
    .local v0, "views":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/view/View;>;"
    iget-object v1, p0, Landroid/support/v4/app/D;->f:Ljava/util/ArrayList;

    invoke-virtual {v1, v0}, Ljava/util/ArrayList;->addAll(Ljava/util/Collection;)Z

    .line 403
    .end local v0    # "views":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/view/View;>;"
    :cond_0
    iget-object v0, p0, Landroid/support/v4/app/D;->g:Ljava/util/ArrayList;

    if-eqz v0, :cond_2

    .line 404
    iget-object v0, p0, Landroid/support/v4/app/D;->h:Ljava/lang/Object;

    if-eqz v0, :cond_1

    .line 405
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    .line 406
    .local v0, "tempExiting":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/view/View;>;"
    iget-object v1, p0, Landroid/support/v4/app/D;->c:Landroid/view/View;

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 407
    iget-object v1, p0, Landroid/support/v4/app/D;->b:Landroid/support/v4/app/P;

    iget-object v2, p0, Landroid/support/v4/app/D;->h:Ljava/lang/Object;

    iget-object v3, p0, Landroid/support/v4/app/D;->g:Ljava/util/ArrayList;

    invoke-virtual {v1, v2, v3, v0}, Landroid/support/v4/app/P;->a(Ljava/lang/Object;Ljava/util/ArrayList;Ljava/util/ArrayList;)V

    .line 410
    .end local v0    # "tempExiting":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/view/View;>;"
    :cond_1
    iget-object v0, p0, Landroid/support/v4/app/D;->g:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->clear()V

    .line 411
    iget-object v0, p0, Landroid/support/v4/app/D;->g:Ljava/util/ArrayList;

    iget-object v1, p0, Landroid/support/v4/app/D;->c:Landroid/view/View;

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 413
    :cond_2
    return-void
.end method
