package fr.arinonia.app.components;

import android.content.Context;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.text.style.UnderlineSpan;
import android.util.AttributeSet;
import android.widget.TextView;

public class UnderlineTextView extends androidx.appcompat.widget.AppCompatTextView {
    private boolean m_modifyingText = false;

    public UnderlineTextView(Context context) {
        super(context);
        init();
    }

    public UnderlineTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public UnderlineTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init() {
        this.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable s) {
                if (m_modifyingText)
                    return;

                underlineText();
            }
        });

        this.underlineText();
    }

    private void underlineText() {
        if (this.m_modifyingText)
            return;

        this.m_modifyingText = true;

        SpannableString content = new SpannableString(getText());
        content.setSpan(new UnderlineSpan(), 0, content.length(), 0);
        this.setText(content);

        this.m_modifyingText = false;
    }
}