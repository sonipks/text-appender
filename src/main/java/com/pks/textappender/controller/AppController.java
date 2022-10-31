package com.pks.textappender.controller;

import com.pks.textappender.helper.AppHelper;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;

import java.util.stream.Collectors;

public class AppController {

    @FXML
    private TextField prefixField;

    @FXML
    private TextField suffixField;

    @FXML
    private TextArea inputArea;

    @FXML
    private TextArea outputArea;


    public void clearInputButtonClick() {
        inputArea.clear();
        inputArea.requestFocus();
    }

    public void singleQuoteButtonClick() {
        joinQuotesAndDelimiterWithText("'");
    }

    private void joinQuotesAndDelimiterWithText(String quoteType) {
        joinPrefixSuffixAndDelimiterWithText(quoteType, quoteType, ",");
    }

    private void joinPrefixSuffixAndDelimiterWithText(String prefixText, String suffixText, String joinDelimiter) {
        AppHelper helper = (prefix, suffix, joiningDelimiter) -> inputArea.getText().lines().map(a -> prefix.trim() + a.trim() + suffix.trim()).collect(Collectors.joining(joiningDelimiter));
        var result = helper.operate(prefixText, suffixText, joinDelimiter);
        outputArea.setText(result);
        clipboardCopy(result);
    }

    private void clipboardCopy(String text) {
        var content = new ClipboardContent();
        content.putString(text);
        Clipboard.getSystemClipboard().setContent(content);
    }

    public void doubleQuoteButtonClick() {
        joinQuotesAndDelimiterWithText("\"");
    }

    public void noQuoteButtonClick() {
        joinQuotesAndDelimiterWithText("");
    }

    public void prefixSuffixButtonClick() {
        joinPrefixSuffixAndDelimiterWithText(prefixField.getText(), suffixField.getText(), "\r\n");
    }

    public void trimSpaceInputButtonClick() {
        var collect = inputArea.getText().lines().map(String::trim).collect(Collectors.joining("\r\n"));
        outputArea.setText(collect);
        clipboardCopy(collect);
    }

    public void moveOutputToInputButtonClick() {
        inputArea.setText(outputArea.getText());
        outputArea.clear();
    }
}