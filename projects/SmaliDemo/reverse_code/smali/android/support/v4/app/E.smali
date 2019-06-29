.class final Landroid/support/v4/app/E;
.super Ljava/lang/Object;
.source ""

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Landroid/support/v4/app/G;->b(Landroid/support/v4/app/P;Landroid/view/ViewGroup;Landroid/view/View;La/b/c/f/b;Landroid/support/v4/app/G$a;Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation


# instance fields
.field final synthetic a:Landroid/support/v4/app/i;

.field final synthetic b:Landroid/support/v4/app/i;

.field final synthetic c:Z

.field final synthetic d:La/b/c/f/b;

.field final synthetic e:Landroid/view/View;

.field final synthetic f:Landroid/support/v4/app/P;

.field final synthetic g:Landroid/graphics/Rect;


# direct methods
.method constructor <init>(Landroid/support/v4/app/i;Landroid/support/v4/app/i;ZLa/b/c/f/b;Landroid/view/View;Landroid/support/v4/app/P;Landroid/graphics/Rect;)V
    .locals 0

    .line 622
    iput-object p1, p0, Landroid/support/v4/app/E;->a:Landroid/support/v4/app/i;

    iput-object p2, p0, Landroid/support/v4/app/E;->b:Landroid/support/v4/app/i;

    iput-boolean p3, p0, Landroid/support/v4/app/E;->c:Z

    iput-object p4, p0, Landroid/support/v4/app/E;->d:La/b/c/f/b;

    iput-object p5, p0, Landroid/support/v4/app/E;->e:Landroid/view/View;

    iput-object p6, p0, Landroid/support/v4/app/E;->f:Landroid/support/v4/app/P;

    iput-object p7, p0, Landroid/support/v4/app/E;->g:Landroid/graphics/Rect;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 5

    .line 625
    iget-object v0, p0, Landroid/support/v4/app/E;->a:Landroid/support/v4/app/i;

    iget-object v1, p0, Landroid/support/v4/app/E;->b:Landroid/support/v4/app/i;

    iget-boolean v2, p0, Landroid/support/v4/app/E;->c:Z

    iget-object v3, p0, Landroid/support/v4/app/E;->d:La/b/c/f/b;

    const/4 v4, 0x0

    invoke-static {v0, v1, v2, v3, v4}, Landroid/support/v4/app/G;->a(Landroid/support/v4/app/i;Landroid/support/v4/app/i;ZLa/b/c/f/b;Z)V

    .line 627
    iget-object v0, p0, Landroid/support/v4/app/E;->e:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 628
    iget-object v1, p0, Landroid/support/v4/app/E;->f:Landroid/support/v4/app/P;

    iget-object v2, p0, Landroid/support/v4/app/E;->g:Landroid/graphics/Rect;

    invoke-virtual {v1, v0, v2}, Landroid/support/v4/app/P;->a(Landroid/view/View;Landroid/graphics/Rect;)V

    .line 630
    :cond_0
    return-void
.end method
