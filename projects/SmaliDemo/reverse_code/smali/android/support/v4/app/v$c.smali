.class Landroid/support/v4/app/v$c;
.super Ljava/lang/Object;
.source ""


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/support/v4/app/v;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "c"
.end annotation


# instance fields
.field public final a:Landroid/view/animation/Animation;

.field public final b:Landroid/animation/Animator;


# direct methods
.method constructor <init>(Landroid/animation/Animator;)V
    .locals 2
    .param p1, "animator"    # Landroid/animation/Animator;

    .line 3953
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 3954
    const/4 v0, 0x0

    iput-object v0, p0, Landroid/support/v4/app/v$c;->a:Landroid/view/animation/Animation;

    .line 3955
    iput-object p1, p0, Landroid/support/v4/app/v$c;->b:Landroid/animation/Animator;

    .line 3956
    if-eqz p1, :cond_0

    .line 3959
    return-void

    .line 3957
    :cond_0
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Animator cannot be null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method constructor <init>(Landroid/view/animation/Animation;)V
    .locals 2
    .param p1, "animation"    # Landroid/view/animation/Animation;

    .line 3945
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 3946
    iput-object p1, p0, Landroid/support/v4/app/v$c;->a:Landroid/view/animation/Animation;

    .line 3947
    const/4 v0, 0x0

    iput-object v0, p0, Landroid/support/v4/app/v$c;->b:Landroid/animation/Animator;

    .line 3948
    if-eqz p1, :cond_0

    .line 3951
    return-void

    .line 3949
    :cond_0
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Animation cannot be null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0
.end method
