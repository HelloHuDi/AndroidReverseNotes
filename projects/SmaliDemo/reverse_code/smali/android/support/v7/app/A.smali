.class Landroid/support/v7/app/A;
.super Ljava/lang/Object;
.source ""

# interfaces
.implements La/b/c/g/g$a;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/support/v7/app/B;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Landroid/support/v7/app/B;


# direct methods
.method constructor <init>(Landroid/support/v7/app/B;)V
    .locals 0
    .param p1, "this$0"    # Landroid/support/v7/app/B;

    .line 45
    iput-object p1, p0, Landroid/support/v7/app/A;->a:Landroid/support/v7/app/B;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Landroid/view/KeyEvent;)Z
    .locals 1
    .param p1, "event"    # Landroid/view/KeyEvent;

    .line 48
    iget-object v0, p0, Landroid/support/v7/app/A;->a:Landroid/support/v7/app/B;

    invoke-virtual {v0, p1}, Landroid/support/v7/app/B;->a(Landroid/view/KeyEvent;)Z

    move-result v0

    return v0
.end method
