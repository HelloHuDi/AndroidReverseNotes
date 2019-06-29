.class Landroid/support/v7/widget/Da;
.super Ljava/lang/Object;
.source ""

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/support/v7/widget/Ea;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Landroid/support/v7/widget/Ea;


# direct methods
.method constructor <init>(Landroid/support/v7/widget/Ea;)V
    .locals 0
    .param p1, "this$0"    # Landroid/support/v7/widget/Ea;

    .line 60
    iput-object p1, p0, Landroid/support/v7/widget/Da;->a:Landroid/support/v7/widget/Ea;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 1

    .line 63
    iget-object v0, p0, Landroid/support/v7/widget/Da;->a:Landroid/support/v7/widget/Ea;

    invoke-virtual {v0}, Landroid/support/v7/widget/Ea;->a()V

    .line 64
    return-void
.end method
