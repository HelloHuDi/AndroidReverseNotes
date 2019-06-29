.class public final enum Landroid/arch/lifecycle/d$a;
.super Ljava/lang/Enum;
.source ""


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/arch/lifecycle/d;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "a"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum<",
        "Landroid/arch/lifecycle/d$a;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Landroid/arch/lifecycle/d$a;

.field public static final enum ON_ANY:Landroid/arch/lifecycle/d$a;

.field public static final enum ON_CREATE:Landroid/arch/lifecycle/d$a;

.field public static final enum ON_DESTROY:Landroid/arch/lifecycle/d$a;

.field public static final enum ON_PAUSE:Landroid/arch/lifecycle/d$a;

.field public static final enum ON_RESUME:Landroid/arch/lifecycle/d$a;

.field public static final enum ON_START:Landroid/arch/lifecycle/d$a;

.field public static final enum ON_STOP:Landroid/arch/lifecycle/d$a;


# direct methods
.method static constructor <clinit>()V
    .locals 9

    .line 119
    new-instance v0, Landroid/arch/lifecycle/d$a;

    const/4 v1, 0x0

    const-string v2, "ON_CREATE"

    invoke-direct {v0, v2, v1}, Landroid/arch/lifecycle/d$a;-><init>(Ljava/lang/String;I)V

    sput-object v0, Landroid/arch/lifecycle/d$a;->ON_CREATE:Landroid/arch/lifecycle/d$a;

    .line 123
    new-instance v0, Landroid/arch/lifecycle/d$a;

    const/4 v2, 0x1

    const-string v3, "ON_START"

    invoke-direct {v0, v3, v2}, Landroid/arch/lifecycle/d$a;-><init>(Ljava/lang/String;I)V

    sput-object v0, Landroid/arch/lifecycle/d$a;->ON_START:Landroid/arch/lifecycle/d$a;

    .line 127
    new-instance v0, Landroid/arch/lifecycle/d$a;

    const/4 v3, 0x2

    const-string v4, "ON_RESUME"

    invoke-direct {v0, v4, v3}, Landroid/arch/lifecycle/d$a;-><init>(Ljava/lang/String;I)V

    sput-object v0, Landroid/arch/lifecycle/d$a;->ON_RESUME:Landroid/arch/lifecycle/d$a;

    .line 131
    new-instance v0, Landroid/arch/lifecycle/d$a;

    const/4 v4, 0x3

    const-string v5, "ON_PAUSE"

    invoke-direct {v0, v5, v4}, Landroid/arch/lifecycle/d$a;-><init>(Ljava/lang/String;I)V

    sput-object v0, Landroid/arch/lifecycle/d$a;->ON_PAUSE:Landroid/arch/lifecycle/d$a;

    .line 135
    new-instance v0, Landroid/arch/lifecycle/d$a;

    const/4 v5, 0x4

    const-string v6, "ON_STOP"

    invoke-direct {v0, v6, v5}, Landroid/arch/lifecycle/d$a;-><init>(Ljava/lang/String;I)V

    sput-object v0, Landroid/arch/lifecycle/d$a;->ON_STOP:Landroid/arch/lifecycle/d$a;

    .line 139
    new-instance v0, Landroid/arch/lifecycle/d$a;

    const/4 v6, 0x5

    const-string v7, "ON_DESTROY"

    invoke-direct {v0, v7, v6}, Landroid/arch/lifecycle/d$a;-><init>(Ljava/lang/String;I)V

    sput-object v0, Landroid/arch/lifecycle/d$a;->ON_DESTROY:Landroid/arch/lifecycle/d$a;

    .line 143
    new-instance v0, Landroid/arch/lifecycle/d$a;

    const/4 v7, 0x6

    const-string v8, "ON_ANY"

    invoke-direct {v0, v8, v7}, Landroid/arch/lifecycle/d$a;-><init>(Ljava/lang/String;I)V

    sput-object v0, Landroid/arch/lifecycle/d$a;->ON_ANY:Landroid/arch/lifecycle/d$a;

    .line 114
    const/4 v0, 0x7

    new-array v0, v0, [Landroid/arch/lifecycle/d$a;

    sget-object v8, Landroid/arch/lifecycle/d$a;->ON_CREATE:Landroid/arch/lifecycle/d$a;

    aput-object v8, v0, v1

    sget-object v1, Landroid/arch/lifecycle/d$a;->ON_START:Landroid/arch/lifecycle/d$a;

    aput-object v1, v0, v2

    sget-object v1, Landroid/arch/lifecycle/d$a;->ON_RESUME:Landroid/arch/lifecycle/d$a;

    aput-object v1, v0, v3

    sget-object v1, Landroid/arch/lifecycle/d$a;->ON_PAUSE:Landroid/arch/lifecycle/d$a;

    aput-object v1, v0, v4

    sget-object v1, Landroid/arch/lifecycle/d$a;->ON_STOP:Landroid/arch/lifecycle/d$a;

    aput-object v1, v0, v5

    sget-object v1, Landroid/arch/lifecycle/d$a;->ON_DESTROY:Landroid/arch/lifecycle/d$a;

    aput-object v1, v0, v6

    sget-object v1, Landroid/arch/lifecycle/d$a;->ON_ANY:Landroid/arch/lifecycle/d$a;

    aput-object v1, v0, v7

    sput-object v0, Landroid/arch/lifecycle/d$a;->$VALUES:[Landroid/arch/lifecycle/d$a;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;I)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()V"
        }
    .end annotation

    .line 115
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Landroid/arch/lifecycle/d$a;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .line 114
    const-class v0, Landroid/arch/lifecycle/d$a;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Landroid/arch/lifecycle/d$a;

    return-object v0
.end method

.method public static values()[Landroid/arch/lifecycle/d$a;
    .locals 1

    .line 114
    sget-object v0, Landroid/arch/lifecycle/d$a;->$VALUES:[Landroid/arch/lifecycle/d$a;

    invoke-virtual {v0}, [Landroid/arch/lifecycle/d$a;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Landroid/arch/lifecycle/d$a;

    return-object v0
.end method
