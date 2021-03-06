package com.wisdom.nhoa.widget;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.HttpParams;
import com.wisdom.nhoa.ConstantString;
import com.wisdom.nhoa.ConstantUrl;
import com.wisdom.nhoa.R;
import com.wisdom.nhoa.util.SharedPreferenceUtil;
import com.wisdom.nhoa.util.StrUtils;
import com.wisdom.nhoa.util.ToastUtil;
import com.wisdom.nhoa.util.http_util.HttpUtil;

import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.Call;
import okhttp3.Response;

/**
 * @author HanXueFeng
 * @ProjectName project： Nhoa
 * @class package：com.wisdom.nhoa.widget
 * @class describe：
 * @time 2018/3/19 16:58
 * @change
 */

public class RefuseIssueDialog extends DialogFragment implements View.OnClickListener {
    private Button btn_confirm;
    private Button btn_cancle;
    private String insid = "";
    private EditText et_reason;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.approval_dialog_refuse_issue, container, false);
        initViews(view);
        return view;
    }

    /**
     * 初始化页面内相关控件
     */
    private void initViews(View view) {
        insid = getArguments().getString("insid");
        btn_cancle = view.findViewById(R.id.approval_refuse_issue_btn_cancle);
        btn_confirm = view.findViewById(R.id.approval_refuse_issue_btn_confirm);
        et_reason = view.findViewById(R.id.approval_refuse_issue_et_suggestion);
        btn_confirm.setOnClickListener(this);
        btn_cancle.setOnClickListener(this);

    }

    /**
     * 页面内点击事件
     *
     * @param v
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.approval_refuse_issue_btn_cancle: {
                this.dismiss();
            }
            break;
            case R.id.approval_refuse_issue_btn_confirm: {
                refuseProject();
            }
            break;
        }
    }

    /**
     * 驳回事项接口
     */
    private void refuseProject() {
        String reason = StrUtils.getEdtTxtContent(et_reason);
        if ("".equals(reason)) {
            ToastUtil.showToast(R.string.sendreceive_receive_reason_hint);
        } else {
            HttpParams params = new HttpParams();
            params.put("appkey", ConstantString.APP_KEY);
            params.put("access_token", SharedPreferenceUtil.getUserInfo(getContext()).getAccess_token());
            params.put("insid", insid);
            params.put("reject_msg", reason);
            HttpUtil.httpGet(ConstantUrl.REFUSE_PROJECT_URL, params, new StringCallback() {
                @Override
                public void onError(Call call, Response response, Exception e) {
                    super.onError(call, response, e);
                    ToastUtil.showToast(e.getMessage());
                }

                @Override
                public void onSuccess(String s, Call call, Response response) {
                    try {
                        JSONObject jsonObject = new JSONObject(s);
                        String code = jsonObject.getString("error_code");
                        if ("0".equals(code)) {
                            RefuseIssueDialog.this.dismiss();
                            ToastUtil.showToast(R.string.sendreceive_receive_reason_success_hint);
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
            });
        }
    }


}
