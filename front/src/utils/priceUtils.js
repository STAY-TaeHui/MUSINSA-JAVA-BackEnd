export const formatPriceToKRW = (price) => {
  const formatted = new Intl.NumberFormat("ko-KR").format(price);

  return formatted;
};
