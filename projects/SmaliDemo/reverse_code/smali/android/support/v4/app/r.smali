.class Landroid/support/v4/app/r;
.super Landroid/support/v4/app/v$b;
.source ""


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Landroid/support/v4/app/v;->a(Landroid/support/v4/app/i;Landroid/support/v4/app/v$c;I)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic b:Landroid/view/ViewGroup;

.field final synthetic c:Landroid/support/v4/app/i;

.field final synthetic d:Landroid/support/v4/app/v;


# direct methods
.method constructor <init>(Landroid/support/v4/app/v;Landroid/view/animation/Animation$AnimationListener;Landroid/view/ViewGroup;Landroid/support/v4/app/i;)V
    .locals 0
    .param p1, "this$0"    # Landroid/support/v4/app/v;
    .param p2, "wrapped"    # Landroid/view/animation/Animation$AnimationListener;

    .line 1639
    iput-object p1, p0, Landroid/support/v4/app/r;->d:Landroid/support/v4/app/v;

    iput-object p3, p0, Landroid/support/v4/app/r;->b:Landroid/view/ViewGroup;

    iput-object p4, p0, Landroid/support/v4/app/r;->c:Landroid/support/v4/app/i;

    invoke-direct {p0, p2}, Landroid/support/v4/app/v$b;-><init>(Landroid/view/animation/Animation$AnimationListener;)V

    return-void
.end method


# virtual methods
.method public onAnimationEnd(Landroid/view/animation/Animation;)V
    .locals 2
    .param p1, "animation"    # Landroid/view/animation/Animation;

    .line 1642
    invoke-super {p0, p1}, Landroid/support/v4/app/v$b;->onAnimationEnd(Landroid/view/animation/Animation;)V

    .line 1647
    iget-object v0, p0, Landroid/support/v4/app/r;->b:Landroid/view/ViewGroup;

    new-instance v1, Landroid/support/v4/app/q;

    invoke-direct {v1, p0}, Landroid/support/v4/app/q;-><init>(Landroid/support/v4/app/r;)V

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->post(Ljava/lang/Runnable;)Z

    .line 1657
    return-void
.end method
