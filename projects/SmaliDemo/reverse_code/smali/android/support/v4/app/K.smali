.class Landroid/support/v4/app/K;
.super Landroid/transition/Transition$EpicenterCallback;
.source ""


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Landroid/support/v4/app/L;->a(Ljava/lang/Object;Landroid/graphics/Rect;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Landroid/graphics/Rect;

.field final synthetic b:Landroid/support/v4/app/L;


# direct methods
.method constructor <init>(Landroid/support/v4/app/L;Landroid/graphics/Rect;)V
    .locals 0
    .param p1, "this$0"    # Landroid/support/v4/app/L;

    .line 305
    iput-object p1, p0, Landroid/support/v4/app/K;->b:Landroid/support/v4/app/L;

    iput-object p2, p0, Landroid/support/v4/app/K;->a:Landroid/graphics/Rect;

    invoke-direct {p0}, Landroid/transition/Transition$EpicenterCallback;-><init>()V

    return-void
.end method


# virtual methods
.method public onGetEpicenter(Landroid/transition/Transition;)Landroid/graphics/Rect;
    .locals 1
    .param p1, "transition"    # Landroid/transition/Transition;

    .line 308
    iget-object v0, p0, Landroid/support/v4/app/K;->a:Landroid/graphics/Rect;

    if-eqz v0, :cond_1

    invoke-virtual {v0}, Landroid/graphics/Rect;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_0

    goto :goto_0

    .line 311
    :cond_0
    iget-object v0, p0, Landroid/support/v4/app/K;->a:Landroid/graphics/Rect;

    return-object v0

    .line 309
    :cond_1
    :goto_0
    const/4 v0, 0x0

    return-object v0
.end method
