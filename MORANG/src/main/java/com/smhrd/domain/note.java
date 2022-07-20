package com.smhrd.domain;

import com.sun.istack.internal.Nullable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor

public class note {

	private int seq;
	
	@NonNull
	private String title;
	
	@NonNull
	private String content;
	
	@NonNull
	private String id;
	
    @Nullable
	private String img1;
	
	private String date;
	
}