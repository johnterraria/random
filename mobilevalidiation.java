package com.filmkio;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.filmkio.nativescreen.net.FkApiClient;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: MobileSessionInvalidation.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m779d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001>B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u0004H\u0002J\u001e\u0010\u001f\u001a\u0004\u0018\u00010 2\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\"H\u0002J\u0010\u0010#\u001a\u00020\u001c2\u0006\u0010$\u001a\u00020\u0004H\u0002J\u0010\u0010%\u001a\u00020\u001c2\u0006\u0010$\u001a\u00020\u0004H\u0002J$\u0010&\u001a\u00020\u00042\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\"2\u0006\u0010'\u001a\u00020\u0004H\u0002J\u000e\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u000bJ\u0010\u0010+\u001a\u00020)2\u0006\u0010,\u001a\u00020\u000bH\u0002J\u0018\u0010-\u001a\u00020\u001c2\u0006\u0010.\u001a\u00020/2\u0006\u0010$\u001a\u00020\u0004H\u0002J\u0010\u00100\u001a\u00020\u001c2\u0006\u0010$\u001a\u00020\u0004H\u0002J\u0010\u00101\u001a\u00020\u001c2\u0006\u0010$\u001a\u00020\u0004H\u0002J\u0018\u00102\u001a\u00020\u001c2\u0006\u00103\u001a\u00020 2\u0006\u00104\u001a\u000205H\u0002J*\u00106\u001a\u00020)2\u0006\u0010.\u001a\u00020/2\u0006\u0010$\u001a\u00020\u00042\u0012\u00107\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\"J\u000e\u00108\u001a\u00020)2\u0006\u0010*\u001a\u00020\u000bJ9\u00109\u001a\u00020\u001c2\u0006\u0010.\u001a\u00020/2\u0006\u0010$\u001a\u00020\u00042\u0012\u00107\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\"2\u0006\u0010:\u001a\u000205H\u0000¢\u0006\u0002\b;J\u001d\u0010<\u001a\u00020\u001c2\u0006\u0010.\u001a\u00020/2\u0006\u0010$\u001a\u00020\u0004H\u0000¢\u0006\u0002\b=R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u000f\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0015\u001a\n \u0017*\u0004\u0018\u00010\u00160\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006?"}, m780d2 = {"Lcom/filmkio/MobileSessionInvalidation;", "", "()V", "DEFAULT_SESSION_INVALID_MESSAGE", "", "EXTRA_SESSION_INVALID_MESSAGE", "IN_FLIGHT_RESET_MS", "", "PROBE_MIN_INTERVAL_MS", "REDIRECT_COOLDOWN_MS", "appContext", "Landroid/content/Context;", "lastProbeAt", "Ljava/util/concurrent/atomic/AtomicLong;", "lastRedirectAt", "mainHandler", "Landroid/os/Handler;", "getMainHandler", "()Landroid/os/Handler;", "mainHandler$delegate", "Lkotlin/Lazy;", "probeExecutor", "Ljava/util/concurrent/ExecutorService;", "kotlin.jvm.PlatformType", "probeInFlight", "Ljava/util/concurrent/atomic/AtomicBoolean;", "redirectInFlight", "containsMarkerToken", "", "text", "marker", "extractRequestSessionIdentity", "Lcom/filmkio/MobileSessionInvalidation$RequestSessionIdentity;", "headers", "", "hasFalseFlag", "responseBody", "hasStrongSessionInvalidMarker", "headerValue", "key", "initialize", "", "context", "invalidateLocalSessionAndRedirect", "ctx", "isSessionInvalidResponse", "code", "", "looksLikeInvalidSessionMessage", "looksLikeLoginRequiredMessage", "matchesCurrentSession", "request", "current", "Lcom/filmkio/Session;", "onApiResponse", "requestHeaders", "probeSessionIfNeeded", "shouldInvalidateForResponse", "currentSession", "shouldInvalidateForResponse$app_mobileRelease", "shouldInvalidateFromProbeResponse", "shouldInvalidateFromProbeResponse$app_mobileRelease", "RequestSessionIdentity", "app_mobileRelease"}, m781k = 1, m782mv = {1, 9, 0}, m784xi = 48)
public final class MobileSessionInvalidation {
    public static final String DEFAULT_SESSION_INVALID_MESSAGE = "نشست شما باطل شده، لطفا مجدد وارد شوید";
    public static final String EXTRA_SESSION_INVALID_MESSAGE = "session_invalid_message";
    private static final long IN_FLIGHT_RESET_MS = 2000;
    private static final long PROBE_MIN_INTERVAL_MS = 30000;
    private static final long REDIRECT_COOLDOWN_MS = 1500;
    private static volatile Context appContext;
    public static final MobileSessionInvalidation INSTANCE = new MobileSessionInvalidation();

    /* JADX INFO: renamed from: mainHandler$delegate, reason: from kotlin metadata */
    private static final Lazy mainHandler = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<Handler>() { // from class: com.filmkio.MobileSessionInvalidation$mainHandler$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Handler invoke() {
            return new Handler(Looper.getMainLooper());
        }
    });
    private static final AtomicBoolean redirectInFlight = new AtomicBoolean(false);
    private static final AtomicLong lastRedirectAt = new AtomicLong(0);
    private static final AtomicBoolean probeInFlight = new AtomicBoolean(false);
    private static final AtomicLong lastProbeAt = new AtomicLong(0);
    private static final ExecutorService probeExecutor = Executors.newSingleThreadExecutor();
    public static final int $stable = 8;

    private MobileSessionInvalidation() {
    }

    private final Handler getMainHandler() {
        return (Handler) mainHandler.getValue();
    }

    /* JADX INFO: compiled from: MobileSessionInvalidation.kt */
    @Metadata(m779d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B\u0017\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\t\u0010\r\u001a\u00020\u0005HÆ\u0003J$\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\n¨\u0006\u0016"}, m780d2 = {"Lcom/filmkio/MobileSessionInvalidation$RequestSessionIdentity;", "", "userId", "", "sessionToken", "", "(Ljava/lang/Long;Ljava/lang/String;)V", "getSessionToken", "()Ljava/lang/String;", "getUserId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "component1", "component2", "copy", "(Ljava/lang/Long;Ljava/lang/String;)Lcom/filmkio/MobileSessionInvalidation$RequestSessionIdentity;", "equals", "", "other", "hashCode", "", "toString", "app_mobileRelease"}, m781k = 1, m782mv = {1, 9, 0}, m784xi = 48)
    private static final /* data */ class RequestSessionIdentity {
        private final String sessionToken;
        private final Long userId;

        public static /* synthetic */ RequestSessionIdentity copy$default(RequestSessionIdentity requestSessionIdentity, Long l, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                l = requestSessionIdentity.userId;
            }
            if ((i & 2) != 0) {
                str = requestSessionIdentity.sessionToken;
            }
            return requestSessionIdentity.copy(l, str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Long getUserId() {
            return this.userId;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getSessionToken() {
            return this.sessionToken;
        }

        public final RequestSessionIdentity copy(Long userId, String sessionToken) {
            Intrinsics.checkNotNullParameter(sessionToken, "sessionToken");
            return new RequestSessionIdentity(userId, sessionToken);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof RequestSessionIdentity)) {
                return false;
            }
            RequestSessionIdentity requestSessionIdentity = (RequestSessionIdentity) other;
            return Intrinsics.areEqual(this.userId, requestSessionIdentity.userId) && Intrinsics.areEqual(this.sessionToken, requestSessionIdentity.sessionToken);
        }

        public int hashCode() {
            Long l = this.userId;
            return ((l == null ? 0 : l.hashCode()) * 31) + this.sessionToken.hashCode();
        }

        public String toString() {
            return "RequestSessionIdentity(userId=" + this.userId + ", sessionToken=" + this.sessionToken + ")";
        }

        public RequestSessionIdentity(Long l, String sessionToken) {
            Intrinsics.checkNotNullParameter(sessionToken, "sessionToken");
            this.userId = l;
            this.sessionToken = sessionToken;
        }

        public final Long getUserId() {
            return this.userId;
        }

        public final String getSessionToken() {
            return this.sessionToken;
        }
    }

    public final void initialize(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        appContext = context.getApplicationContext();
    }

    public final void onApiResponse(int code, String responseBody, Map<String, String> requestHeaders) {
        Context context;
        Intrinsics.checkNotNullParameter(responseBody, "responseBody");
        Intrinsics.checkNotNullParameter(requestHeaders, "requestHeaders");
        if (Intrinsics.areEqual(AppState.INSTANCE.getClientPlatform(), "android") && (context = appContext) != null) {
            Session session = AppState.INSTANCE.getSession();
            if (session == null) {
                session = SessionStore.INSTANCE.load(context);
                AppState.INSTANCE.setSession(session);
                if (session == null) {
                    return;
                }
            }
            if (shouldInvalidateForResponse$app_mobileRelease(code, responseBody, requestHeaders, session)) {
                invalidateLocalSessionAndRedirect(context);
            }
        }
    }

    public final boolean shouldInvalidateForResponse$app_mobileRelease(int code, String responseBody, Map<String, String> requestHeaders, Session currentSession) {
        Intrinsics.checkNotNullParameter(responseBody, "responseBody");
        Intrinsics.checkNotNullParameter(requestHeaders, "requestHeaders");
        Intrinsics.checkNotNullParameter(currentSession, "currentSession");
        RequestSessionIdentity requestSessionIdentityExtractRequestSessionIdentity = extractRequestSessionIdentity(requestHeaders);
        if (requestSessionIdentityExtractRequestSessionIdentity != null && matchesCurrentSession(requestSessionIdentityExtractRequestSessionIdentity, currentSession)) {
            return isSessionInvalidResponse(code, responseBody);
        }
        return false;
    }

    public final void probeSessionIfNeeded(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (Intrinsics.areEqual(AppState.INSTANCE.getClientPlatform(), "android")) {
            final String apiBase = AppState.INSTANCE.getApiBase();
            if (apiBase == null) {
                apiBase = "";
            }
            if (StringsKt.isBlank(apiBase)) {
                return;
            }
            final Context applicationContext = context.getApplicationContext();
            final Session session = AppState.INSTANCE.getSession();
            if (session == null) {
                SessionStore sessionStore = SessionStore.INSTANCE;
                Intrinsics.checkNotNull(applicationContext);
                session = sessionStore.load(applicationContext);
                AppState.INSTANCE.setSession(session);
            }
            if (session == null || session.getUserId() <= 0 || StringsKt.isBlank(session.getSessionToken())) {
                return;
            }
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            AtomicLong atomicLong = lastProbeAt;
            long j = atomicLong.get();
            if (jElapsedRealtime - j >= 30000 && atomicLong.compareAndSet(j, jElapsedRealtime) && probeInFlight.compareAndSet(false, true)) {
                probeExecutor.execute(new Runnable() { // from class: com.filmkio.MobileSessionInvalidation$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        MobileSessionInvalidation.probeSessionIfNeeded$lambda$2(session, apiBase, applicationContext);
                    }
                });
            }
        }
    }

    public static final void probeSessionIfNeeded$lambda$2(Session session, String apiBase, Context context) {
        Intrinsics.checkNotNullParameter(apiBase, "$apiBase");
        try {
            String strSignedRequest$default = FkApiClient.signedRequest$default(FkApiClient.INSTANCE, apiBase, "/userData", "GET", MapsKt.mapOf(TuplesKt.m787to("userID", String.valueOf(session.getUserId()))), MapsKt.mapOf(TuplesKt.m787to("x-fk-user-id", String.valueOf(session.getUserId())), TuplesKt.m787to("x-fk-session", session.getSessionToken())), null, true, 32, null);
            MobileSessionInvalidation mobileSessionInvalidation = INSTANCE;
            if (mobileSessionInvalidation.shouldInvalidateFromProbeResponse$app_mobileRelease(200, strSignedRequest$default)) {
                Intrinsics.checkNotNull(context);
                mobileSessionInvalidation.invalidateLocalSessionAndRedirect(context);
            }
        } catch (FkApiClient.ApiException e) {
            try {
                MobileSessionInvalidation mobileSessionInvalidation2 = INSTANCE;
                if (mobileSessionInvalidation2.shouldInvalidateFromProbeResponse$app_mobileRelease(e.getCode(), e.getBody())) {
                    Intrinsics.checkNotNull(context);
                    mobileSessionInvalidation2.invalidateLocalSessionAndRedirect(context);
                }
            } finally {
                probeInFlight.set(false);
            }
        } catch (Throwable unused) {
        }
    }

    private final void invalidateLocalSessionAndRedirect(final Context ctx) {
        Session session = AppState.INSTANCE.getSession();
        if (session == null) {
            session = SessionStore.INSTANCE.load(ctx);
            AppState.INSTANCE.setSession(session);
        }
        if (session == null || session.getUserId() <= 0 || StringsKt.isBlank(session.getSessionToken())) {
            return;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        AtomicLong atomicLong = lastRedirectAt;
        long j = atomicLong.get();
        if (jElapsedRealtime - j >= 1500 && atomicLong.compareAndSet(j, jElapsedRealtime) && redirectInFlight.compareAndSet(false, true)) {
            AppState.INSTANCE.setSession(null);
            SessionStore.INSTANCE.clear(ctx);
            getMainHandler().post(new Runnable() { // from class: com.filmkio.MobileSessionInvalidation$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    MobileSessionInvalidation.invalidateLocalSessionAndRedirect$lambda$6(ctx);
                }
            });
        }
    }

    public static final void invalidateLocalSessionAndRedirect$lambda$6(Context ctx) {
        Handler mainHandler2;
        Runnable runnable;
        Intrinsics.checkNotNullParameter(ctx, "$ctx");
        try {
            Intent intent = new Intent(ctx, (Class<?>) MainActivity.class);
            intent.putExtra("open_tab", "account");
            intent.putExtra("force_login", true);
            intent.putExtra(EXTRA_SESSION_INVALID_MESSAGE, DEFAULT_SESSION_INVALID_MESSAGE);
            intent.addFlags(268468224);
            ctx.startActivity(intent);
            mainHandler2 = INSTANCE.getMainHandler();
            runnable = new Runnable() { // from class: com.filmkio.MobileSessionInvalidation$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    MobileSessionInvalidation.invalidateLocalSessionAndRedirect$lambda$6$lambda$5();
                }
            };
        } catch (Throwable unused) {
            mainHandler2 = INSTANCE.getMainHandler();
            runnable = new Runnable() { // from class: com.filmkio.MobileSessionInvalidation$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    MobileSessionInvalidation.invalidateLocalSessionAndRedirect$lambda$6$lambda$5();
                }
            };
        }
        mainHandler2.postDelayed(runnable, 2000L);
    }

    public static final void invalidateLocalSessionAndRedirect$lambda$6$lambda$5() {
        redirectInFlight.set(false);
    }

    private final boolean isSessionInvalidResponse(int code, String responseBody) {
        if (hasStrongSessionInvalidMarker(responseBody)) {
            return true;
        }
        if (code == 401 || code == 403) {
            return looksLikeInvalidSessionMessage(responseBody);
        }
        return false;
    }

    private final RequestSessionIdentity extractRequestSessionIdentity(Map<String, String> headers) {
        if (headers.isEmpty()) {
            return null;
        }
        String string = StringsKt.trim((CharSequence) headerValue(headers, "x-fk-session")).toString();
        if (StringsKt.isBlank(string)) {
            return null;
        }
        return new RequestSessionIdentity(StringsKt.toLongOrNull(StringsKt.trim((CharSequence) headerValue(headers, "x-fk-user-id")).toString()), string);
    }

    private final String headerValue(Map<String, String> headers, String key) {
        Object next;
        String str = headers.get(key);
        if (str != null) {
            return str;
        }
        Iterator<T> it = headers.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (StringsKt.equals((String) ((Map.Entry) next).getKey(), key, true)) {
                break;
            }
        }
        Map.Entry entry = (Map.Entry) next;
        String str2 = entry != null ? (String) entry.getValue() : null;
        return str2 == null ? "" : str2;
    }

    private final boolean matchesCurrentSession(RequestSessionIdentity request, Session current) {
        if (!Intrinsics.areEqual(request.getSessionToken(), current.getSessionToken())) {
            return false;
        }
        Long userId = request.getUserId();
        if (userId == null || userId.longValue() <= 0) {
            return true;
        }
        return userId.longValue() == current.getUserId();
    }

    private final boolean hasStrongSessionInvalidMarker(String responseBody) {
        List<String> groupValues;
        String str;
        List<String> groupValues2;
        String str2;
        if (StringsKt.isBlank(responseBody)) {
            return false;
        }
        String lowerCase = responseBody.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        Set of = SetsKt.setOf((Object[]) new String[]{"fk_session_invalid", "fk_no_session", "fk_session_replaced", "rest_not_logged_in", "invalid_session"});
        String str3 = lowerCase;
        String string = null;
        MatchResult matchResultFind$default = Regex.find$default(new Regex("\"code\"\\s*:\\s*\"([^\"]+)\""), str3, 0, 2, null);
        String string2 = (matchResultFind$default == null || (groupValues2 = matchResultFind$default.getGroupValues()) == null || (str2 = (String) CollectionsKt.getOrNull(groupValues2, 1)) == null) ? null : StringsKt.trim((CharSequence) str2).toString();
        if (string2 == null) {
            string2 = "";
        }
        if (of.contains(string2)) {
            return true;
        }
        MatchResult matchResultFind$default2 = Regex.find$default(new Regex("\"status\"\\s*:\\s*\"([^\"]+)\""), str3, 0, 2, null);
        if (matchResultFind$default2 != null && (groupValues = matchResultFind$default2.getGroupValues()) != null && (str = (String) CollectionsKt.getOrNull(groupValues, 1)) != null) {
            string = StringsKt.trim((CharSequence) str).toString();
        }
        if (of.contains(string != null ? string : "")) {
            return true;
        }
        Set set = of;
        if ((set instanceof Collection) && set.isEmpty()) {
            return false;
        }
        Iterator it = set.iterator();
        while (it.hasNext()) {
            if (INSTANCE.containsMarkerToken(lowerCase, (String) it.next())) {
                return true;
            }
        }
        return false;
    }

    private final boolean containsMarkerToken(String text, String marker) {
        String str = text;
        if (StringsKt.isBlank(str) || StringsKt.isBlank(marker)) {
            return false;
        }
        return new Regex("(^|[^a-z0-9_])" + Regex.INSTANCE.escape(marker) + "([^a-z0-9_]|$)").containsMatchIn(str);
    }

    private final boolean looksLikeInvalidSessionMessage(String responseBody) {
        String str = responseBody;
        if (StringsKt.isBlank(str)) {
            return false;
        }
        String lowerCase = responseBody.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        String str2 = lowerCase;
        if (StringsKt.contains$default((CharSequence) str2, (CharSequence) "invalid session", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) str2, (CharSequence) "session invalid", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) str2, (CharSequence) "session expired", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) str2, (CharSequence) "session has expired", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) str2, (CharSequence) "session is expired", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) str2, (CharSequence) "session revoked", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) str2, (CharSequence) "session replaced", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) str2, (CharSequence) "session not valid", false, 2, (Object) null)) {
            return true;
        }
        if (StringsKt.contains$default((CharSequence) str, (CharSequence) "نشست", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) str, (CharSequence) "سشن", false, 2, (Object) null)) {
            return StringsKt.contains$default((CharSequence) str, (CharSequence) "منقضی", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) str, (CharSequence) "باطل", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) str, (CharSequence) "فعال نیست", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) str, (CharSequence) "نامعتبر", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) str, (CharSequence) "دوباره وارد", false, 2, (Object) null);
        }
        return false;
    }

    public final boolean shouldInvalidateFromProbeResponse$app_mobileRelease(int code, String responseBody) {
        Intrinsics.checkNotNullParameter(responseBody, "responseBody");
        if (hasStrongSessionInvalidMarker(responseBody) || looksLikeInvalidSessionMessage(responseBody)) {
            return true;
        }
        if (!looksLikeLoginRequiredMessage(responseBody)) {
            return false;
        }
        if (code == 401 || code == 403) {
            return true;
        }
        return hasFalseFlag(responseBody);
    }

    private final boolean hasFalseFlag(String responseBody) {
        if (StringsKt.isBlank(responseBody)) {
            return false;
        }
        String lowerCase = responseBody.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        String str = lowerCase;
        return new Regex("\"flag\"\\s*:\\s*false").containsMatchIn(str) || new Regex("\"flag\"\\s*:\\s*\"false\"").containsMatchIn(str);
    }

    private final boolean looksLikeLoginRequiredMessage(String responseBody) {
        String str = responseBody;
        if (StringsKt.isBlank(str)) {
            return false;
        }
        String lowerCase = responseBody.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        String str2 = lowerCase;
        if (StringsKt.contains$default((CharSequence) str2, (CharSequence) "please login", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) str2, (CharSequence) "please log in", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) str2, (CharSequence) "login required", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) str2, (CharSequence) "authorization required", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) str2, (CharSequence) "not logged in", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) str2, (CharSequence) "user not logged in", false, 2, (Object) null)) {
            return true;
        }
        return StringsKt.contains$default((CharSequence) str, (CharSequence) "ابتدا وارد شوید", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) str, (CharSequence) "لطفا وارد شوید", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) str, (CharSequence) "نیاز به ورود", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) str, (CharSequence) "وارد حساب", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) str, (CharSequence) "کاربر وارد نشده", false, 2, (Object) null);
    }
}
