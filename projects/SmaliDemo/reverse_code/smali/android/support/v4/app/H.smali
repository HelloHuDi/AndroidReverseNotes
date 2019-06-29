.class Landroid/support/v4/app/H;
.super Landroid/transition/Transition$EpicenterCallback;
.source ""


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Landroid/support/v4/app/L;->c(Ljava/lang/Object;Landroid/view/View;)V
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

    .line 81
    iput-object p1, p0, Landroid/support/v4/app/H;->b:Landroid/support/v4/app/L;

    iput-object p2, p0, Landroid/support/v4/app/H;->a:Landroid/graphics/Rect;

    invoke-direct {p0}, Landroid/transition/Transition$EpicenterCallback;-><init>()V

    return-void
.end method


# virtual methods
.method public onGetEpicenter(Landroid/transition/Transition;)Landroid/graphics/Rect;
    .locals 1
    .param p1, "transition"    # Landroid/transition/Transition;

    .line 84
    iget-object v0, p0, Landroid/support/v4/app/H;->a:Landroid/graphics/Rect;

    return-object v0
.end method
