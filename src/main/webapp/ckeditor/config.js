/**
 * @license Copyright (c) 2003-2019, CKSource - Frederico Knabben. All rights reserved.
 * For licensing, see https://ckeditor.com/legal/ckeditor-oss-license
 */

CKEDITOR.editorConfig = function( config ) {
	// Define changes to default configuration here. For example:
	// config.language = 'fr';
	// config.uiColor = '#AADC6E';

	config.toolbarGroups = [
		{ name: 'clipboard',   groups: [ 'clipboard', 'undo' ] },
		{ name: 'editing',     groups: [ 'find', 'selection', 'spellchecker' ] },
		{ name: 'links' },
		{ name: 'insert' },
		{ name: 'forms' },
		{ name: 'tools' },
		{ name: 'document',	   groups: [ 'mode', 'document', 'doctools' ] },
		{ name: 'others' },
		'/',
		{ name: 'basicstyles', groups: [ 'basicstyles', 'cleanup' ] },
		{ name: 'paragraph',   groups: [ 'list', 'indent', 'blocks', 'align', 'bidi' ] },
		{ name: 'styles' },
		{ name: 'colors' },
		{ name: 'about' }
	];

	// Remove some buttons provided by the standard plugins, which are
	// not needed in the Standard(s) toolbar.
	config.removeButtons = 'Underline,Subscript,Superscript';

	// Set the most common block elements.
	config.format_tags = 'p;h1;h2;h3;pre';

	// Simplify the dialog windows.
	config.removeDialogTabs = 'image:advanced;link:advanced';

	config.image_previewText=' ';
    config.toolbar = 'Full';
    config.toolbar_Full =
        [
            { name: 'document', items : ['DocProps','Preview','Print','-','Templates' ] },
            { name: 'clipboard', items : [ 'Cut','Copy','Paste','PasteText','PasteFromWord','-','Undo','Redo' ] },
            { name: 'editing', items : [ 'Find','Replace','-','SelectAll','-','SpellChecker', 'Scayt' ] },
            { name: 'forms', items : [ 'Form', 'Checkbox', 'Radio', 'TextField', 'Textarea', 'Select', 'Button', 'ImageButton',
                    'HiddenField' ] },
            '/',
            { name: 'basicstyles', items : [ 'Bold','Italic','Underline','Strike','Subscript','Superscript','-','RemoveFormat' ] },
            { name: 'paragraph', items : [ 'NumberedList','BulletedList','-','Outdent','Indent','-','Blockquote','CreateDiv',
                    '-','JustifyLeft','JustifyCenter','JustifyRight','JustifyBlock','-','BidiLtr','BidiRtl' ] },
            { name: 'links', items : [ 'Link','Unlink','Anchor' ] },
            { name: 'insert', items : [ 'Image','Flash','Table','HorizontalRule','Smiley','SpecialChar','PageBreak','Iframe' ] },
            '/',
            { name: 'styles', items : [ 'Styles','Format','Font','FontSize' ] },
            { name: 'colors', items : [ 'TextColor','BGColor' ] },
            { name: 'tools', items : [ 'Maximize', 'ShowBlocks','-','About' ] }
        ];
    // config.uploadUrl=;  //上传图片

    config.filebrowserImageUploadUrl= "/uploadPic";
    //表情，如果还有可自行增加
    config.smiley_images = ['i_f01.gif','i_f02.gif','i_f03.gif','i_f04.gif','i_f05.gif','i_f06.gif','i_f07.gif','i_f08.gif','i_f09.gif','i_f10.gif','i_f11.gif','i_f12.gif','i_f13.gif','i_f14.gif','i_f15.gif','i_f16.gif','i_f17.gif','i_f18.gif','i_f19.gif','i_f20.gif','i_f21.gif','i_f22.gif','i_f23.gif','i_f24.gif','i_f25.gif','i_f26.gif','i_f27.gif',
        'i_f28.gif','i_f29.gif','i_f30.gif','i_f31.gif','i_f32.gif','i_f33.gif','i_f34.gif','i_f35.gif','i_f36.gif','i_f37.gif','i_f38.gif','i_f39.gif','i_f40.gif','i_f41.gif','i_f42.gif','i_f43.gif','i_f44.gif','i_f45.gif',
        'i_f46.gif','i_f47.gif','i_f48.gif','i_f49.gif','i_f50.gif'];
    config.smiley_columns = 8; //每行显示的表情个数
};
